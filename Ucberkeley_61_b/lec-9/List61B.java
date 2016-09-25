/**
 * Define a list interface for all lists present, past, future
 * @author yiddi
 *
 */
public interface List61B<Blorp> {
	public void insertFront(Blorp x);
	public Blorp getFront();
	public void insertBack(Blorp x);
	public Blorp getBack();
	public Blorp deleteBack();
	public int size();
	public Blorp get(int position);
	public void insert(Blorp item, int position);
}
