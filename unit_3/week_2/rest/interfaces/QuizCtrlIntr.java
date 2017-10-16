package controllers;

public interface QuizCtrlIntr {
	public String ping();
	public List<Quiz> index(HttpServletResponse res);
	public Quiz show(int id, HttpServletResponse res);
	public Quiz create(String quizJSON, HttpServletResponse res);
	public Quiz update(int id, String quizJSON, HttpServletResponse res);
	public boolean destroy(int id, HttpServletResponse res);
	public Set<Question> showQuestions(int id, HttpServletResponse res);
	public Question createQuestions(int id, String questionJson, HttpServletResponse res);
	public  boolean destroyQuestions(int id, int questid, HttpServletResponse res);
}
