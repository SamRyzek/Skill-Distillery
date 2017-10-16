package data;

public interface QuizDAOIntr {
	public List<Quiz> index();
	public Quiz show(int id);
	public Quiz create(Quiz quiz);
	public Quiz update(int id, Quiz quiz);
	public boolean destroy(int id);
	public Set<Question> showQuestions(int id);
	public Question createQuestion(int id, Question q);
	public boolean destroyQuestion(int id, int questid);
}
