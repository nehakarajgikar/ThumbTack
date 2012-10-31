import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

//	public static Map<String, HashMap<Integer, Integer>> db = new HashMap<String, HashMap<Integer, Integer>>();

	public static Map<String, LinkedList<ValueObject>> newDB=new HashMap<String, LinkedList<ValueObject>>();
	
	public static Map<Integer, Integer> valMap=new HashMap<Integer, Integer>();
	public enum Command{
		SET,UNSET,GET,NUMEQUALTO,BEGIN,ROLLBACK,COMMIT
	}
	
	public static Stack<Integer> tStk=new Stack<Integer>();
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Read input: ");
		String input = null;
		Main main=new Main();
		
		while (!(input = sc.next()).equals("END")) {
			String[] tokens=input.split("\\s+");
			
			switch (Command.valueOf(tokens[0])) {
			case SET:
				main.set(tokens[1],Integer.parseInt(tokens[2]));
				break;
			case UNSET:
				main.unset(tokens[1]);
				break;

			case GET:
				Integer val=main.get(tokens[1]);
				break;
			case NUMEQUALTO:
				Integer num=main.numequalto(Integer.parseInt(tokens[1]));
				break;
			case BEGIN:
				Integer tid=main.beginTransaction();
				tStk.push(tid);
				break;
			case ROLLBACK:
				main.rollback(tStk.pop());
				break;
			case COMMIT:
				main.commit();
				break;
			default:
				System.err.println("ERROR in input");
				return;
			}
		}

	}
	private void set(String varName, int value) {
		//get current tid
		Integer tid=tStk.peek();
		ValueObject vo=new ValueObject(value, tid);
		LinkedList<ValueObject> valList=newDB.get(varName);
		if(valList==null){
			valList=new LinkedList<ValueObject>();
			newDB.put(varName, valList);
		}
		//check if the last VO in valList belongs to a different transaciton.
		//if different transaction, then you can add directly
		if(valList.getLast()==null){
			valList.add(vo);
			return;
		}
		ValueObject voLast=valList.getLast();
		
		
		if(voLast.tid==tid){
			valList.removeLast();
		}
		valList.add(vo);
		
	}
	private void unset(String var) {

		this.set(var, -1);
//		Integer tid=tStk.peek();
		
	}
	private Integer get(String var) {
		
		return null;
	}
	private Integer numequalto(int parseInt) {
		// TODO Auto-generated method stub
		return null;
	}
	private Integer beginTransaction() {
		// TODO Auto-generated method stub
		return null;
	}
	private void rollback(Integer pop) {
		// TODO Auto-generated method stub
		
	}
	private void commit() {
		// TODO Auto-generated method stub
		
	}

}
