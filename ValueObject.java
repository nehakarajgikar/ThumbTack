/**
 * 
 */

/**
 * @author neha
 * 
 */
public class ValueObject {

	public Integer value;
	public Long tid;

	public ValueObject() {
	}

	public ValueObject(Integer value, Long tid) {
		if (value == -1) {
			this.value = null;
		} else {
			this.value = value;
		}
		this.tid = tid;
	}
	
	public String toString(){
		return this.tid + " "+this.value;
	}
}
