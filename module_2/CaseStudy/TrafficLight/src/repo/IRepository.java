package repo;

import java.util.List;

public interface IRepository<T> {
	   List<T> getAll();
	    void update(List<T> t);
	    void add(T t);
		void delete(int id);
}
