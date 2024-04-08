package Repo.Interface;

import java.util.List;
import java.util.Set;

import Model.Contract;
import Repo.IRepository;

public interface IContractRepository<T> {
	List<T> getAll();
    void update(List<T> t);
    void add(T t);
	void delete(int id);
}
