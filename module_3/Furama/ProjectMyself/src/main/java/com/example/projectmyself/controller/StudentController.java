package com.example.projectmyself.controller;

import com.example.projectmyself.dto.StudentList;
import com.example.projectmyself.model.ClassStudent;
import com.example.projectmyself.model.Student;
import com.example.projectmyself.model.Tutor;
import com.example.projectmyself.service.IClassService;
import com.example.projectmyself.service.IRepoService;
import com.example.projectmyself.service.ITutorService;
import com.example.projectmyself.service.imp.ClassService;
import com.example.projectmyself.service.imp.StudentService;
import com.example.projectmyself.service.imp.TutorService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import static java.nio.file.Files.delete;
import static jdk.nashorn.internal.objects.NativeString.search;

@WebServlet(name = "Student", value = "/student")
public class StudentController extends HttpServlet {
    IClassService classService = new ClassService();
    IRepoService studentService = new StudentService();
    ITutorService tutorService = new TutorService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                try {
                    save(req, resp);
                } catch (SQLException e) {


                }
                break;
            case "delete":
                delete(req, resp);
                break;
            case "update":
                try {
                    update(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            default:

        }
    }

    private void update(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int classID = Integer.parseInt(req.getParameter("classId"));
        int tutorID = Integer.parseInt(req.getParameter("tutorId"));
        Student student = new Student(id, name, classID,tutorID);
        boolean isSuccess = studentService.update(student);
        String mess = "Update successful";
        if (!isSuccess) {
            mess = "Update failed";
        }
        try {
            resp.sendRedirect("/student?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        boolean check = studentService.delete(deleteId);
        String mess = "khong thanh cong";
        if (check) {
            mess = "Thanh cong";
        }
        try {
            resp.sendRedirect("/student?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void save(HttpServletRequest req, HttpServletResponse resp) throws SQLException {
        String name = req.getParameter("name");
        int classId = Integer.parseInt(req.getParameter("classId"));
        int tutorId = Integer.parseInt(req.getParameter("tutorId"));
        Student student = new Student(name,classId,tutorId);
        boolean isSuccess = studentService.add(student);
        String mess = "Add new student successful";
        if (!isSuccess) {
            mess = "Add Failed";
        }
        try {
            resp.sendRedirect("/student?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "add":
                showFormAdd(req, resp);
                break;
            case "update":
                try {
                    showFormUpdate(req,resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            case "searchByName":
                searchByName(req,resp);
                break;

            default:
                showList(req, resp);
        }

    }



    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        // chuyển qua làm chức năng search
//        List<Tutor> tutorList = tutorService.findAll();
//        List<ClassStudent> classStudentList = classService.findAll();

        // danh sách sản phẩm
        List<StudentList> studentLists = studentService.getAll();
        try {
//            req.setAttribute("tutorList", tutorList);
//            req.setAttribute("classList", classStudentList);
            req.setAttribute("studentList", studentLists);
            req.getRequestDispatcher("/view/List.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = studentService.getStudentByID(id);
        req.setAttribute("student", student);
        req.setAttribute("tutorList", tutorService.findAll());
        req.setAttribute("classList", classService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/Update.jsp");
        requestDispatcher.forward(req, resp);
    }

    private void showFormAdd(HttpServletRequest req, HttpServletResponse resp) {
        req.setAttribute("tutorList", tutorService.findAll());
        req.setAttribute("classList", classService.findAll());

        try {
            req.getRequestDispatcher("/view/Add.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private void searchByName(HttpServletRequest req, HttpServletResponse resp)  {
        String searchName = req.getParameter("searchName");
//        String searchClass = req.getParameter("searchClassID");
//        String searchTutor = req.getParameter("searchTutor");
//        List<ClassStudent> classStudentList = classService.findAll();
//        List<Tutor> tutorList = tutorService.findAll();

        // chuyển name qua để giữ lại
        req.setAttribute("searchName",searchName);
//        req.setAttribute("searchTutor",searchClass);
//        req.setAttribute("searchClassID",searchTutor);
        try {
            List<StudentList> studentLists = studentService.getStudentByName(searchName);
                req.setAttribute("studentList", studentLists);
                req.getRequestDispatcher("/view/List.jsp").forward(req, resp);


        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
