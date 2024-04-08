package Repo.Interface;

import java.awt.print.Book;
import java.util.List;
import java.util.Set;

import Repo.IRepository;

public interface IBookingRepository<Booking> {
	Set<Booking> getAll();

    void add(Booking t);

    void update(Set<Booking> t);
	
}
