package service;

import model.TestQ;

public interface TestQService {

	public void save(TestQ tq);

	public void remove(String name);

	public TestQ find(String name);

}
