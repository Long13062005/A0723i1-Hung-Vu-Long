package controller;

import dto.BenhNhanDto;
import service.IBenhAnService;
import service.IBenhNhanService;
import service.imp.BenhAnService;
import service.imp.BenhNhanService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "BenhNhan", value = "/hospital")

public class BenhNhanController extends HttpServlet {
    IBenhNhanService benhNhanService = new BenhNhanService();
    IBenhAnService benhAnService = new BenhAnService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
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
        String nameVictim = req.getParameter("name");
        String dateStart = req.getParameter("dateStart");
        String dateEnd = req.getParameter("dateEnd");
        String reason = req.getParameter("reason");
        BenhNhan benhNhan = new BenhNhan(id, nameVictim, dateStart,dateEnd,reason);
        boolean isSuccess = benhNhanService.update(benhNhan);
        String mess = "Update successful";
        if (!isSuccess) {
            mess = "Update failed";
        }
        try {
            resp.sendRedirect("/hospital?mess=" + mess);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void delete(HttpServletRequest req, HttpServletResponse resp) {
        int deleteId = Integer.parseInt(req.getParameter("deleteId"));
        boolean check = benhNhanService.delete(deleteId);
        String mess = "khong thanh cong";
        if (check) {
            mess = "Thanh cong";
        }
        try {
            resp.sendRedirect("/hospital?mess=" + mess);
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
            case "update":
                try {
                    showFormUpdate(req, resp);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
                showList(req, resp);
        }
    }

    private void showList(HttpServletRequest req, HttpServletResponse resp) {
        List<BenhNhanDto> benhNhanDto = benhNhanService.getAll();
        try {

            req.setAttribute("benhNhanList", benhNhanDto);
            req.getRequestDispatcher("/view/list.jsp").forward(req, resp);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void showFormUpdate(HttpServletRequest req, HttpServletResponse resp) throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        BenhNhan benhNhan = benhNhanService.getVictimByID(id);
        req.setAttribute("benhNhan", benhNhan);
        req.setAttribute("benhAnList", benhAnService.findAll());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/view/update.jsp");
        requestDispatcher.forward(req, resp);
    }

}
