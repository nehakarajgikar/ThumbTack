/**
 * 
 */

/**
 * @author neha
 * 
 */
public class ValueObject {

	public Integer value;
	public int tid;

	public ValueObject() {
	}

	public ValueObject(int value, int tid) {
		if (value == -1) {
			this.value = null;
		} else {
			this.value = value;
		}
		this.tid = tid;
	}
}
