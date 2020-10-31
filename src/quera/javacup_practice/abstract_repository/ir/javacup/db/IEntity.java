package quera.javacup_practice.abstract_repository.ir.javacup.db;

public interface IEntity<I> {

	void setId(I id);
	
	I getId();
}
