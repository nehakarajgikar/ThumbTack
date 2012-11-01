/**
 * 
 */

/**
 * @author neha
 * 
 */
public class ValueObject {

	public Integer value;
	public long tid;

	public ValueObject() {
	}

	public ValueObject(int value, long tid) {
		if (value == -1) {
			this.value = null;
		} else {
			this.value = value;
		}
		this.tid = tid;
	}
}
