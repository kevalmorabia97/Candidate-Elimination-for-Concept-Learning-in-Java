import java.util.ArrayList;
import java.util.Arrays;

public class TargetConcept {
	Hypothesis specificBoundary;
	ArrayList<Hypothesis> genericBoundary = new ArrayList<>();
	int currentPositiveClassification;
	String[][] totalAttributes;
	int noOfAttributes;

	public TargetConcept(int cpc, String[][] tattr){
		noOfAttributes = tattr.length;
		specificBoundary = new Hypothesis(noOfAttributes);
		currentPositiveClassification = cpc;
		totalAttributes = tattr;
		
		for(int i = 0; i < specificBoundary.attribute.length; i++)	specificBoundary.attribute[i] = "none";	

		Hypothesis mostGeneral = new Hypothesis(noOfAttributes);
		for(int i = 0; i < mostGeneral.attribute.length; i++)	mostGeneral.attribute[i] = "all";
		genericBoundary.add(mostGeneral);
	}
	
	//Here all positive examples come before all negative examples
	public boolean addTrainingInstance(String[] trainingInstance){
		int classification = Integer.parseInt(trainingInstance[trainingInstance.length-1])==currentPositiveClassification ? 1 : 0;
		
		if(classification == 1){//positive Instance
			//generalize S
			for(int i = 0; i < totalAttributes.length; i++){
				if(specificBoundary.attribute[i].equals("all"))		continue;
				if(!specificBoundary.attribute[i].equals(trainingInstance[i])){
					if(specificBoundary.attribute[i].equals("none")){
						specificBoundary.attribute[i] = new String(trainingInstance[i]);
					}else{
						specificBoundary.attribute[i] = "all";
					}
				}
			}
		}else{//negative Instance
			//specialize G
			/* For each hypothesis g that is not consistent with the trainingInstance, remove g
			 * add to G all minimal specializations h such that h is consistent with the trainingInstance 
			 * and some member of S is more specific than than h
			*/ 
			for(int i = 0; i < genericBoundary.size(); i++){
				Hypothesis g = genericBoundary.get(i);
				if(!g.isConsistent(trainingInstance, classification)){
					ArrayList<Hypothesis> minSpec = minimalSpecialization(g,trainingInstance);
					genericBoundary.remove(g);
					//System.out.println("Removed "+Arrays.toString(g.attribute));
					i--;
					for(Hypothesis ms : minSpec)	genericBoundary.add(ms);
					
					//Remove from G any hypothesis that is less general the another hypothesis in G
					int n = genericBoundary.size();
					int[] flag = new int[n];//flag=1 --> remove that hypothesis as it is less general than another hypothesis
					for(int j = 0; j < n; j++){
						for(int k = j+1; k < n; k++){
							Hypothesis h1 = genericBoundary.get(j), h2 = genericBoundary.get(k);
							if(h1.isLessGeneralThan(h2)){
								flag[j]=1;
								break;
							}else if(h2.isLessGeneralThan(h1))	flag[k] = 1;
						}
					}
					for(int j = n-1; j>=0; j--){
						if(flag[j]==1)	genericBoundary.remove(j);
					}
				}
			}
			if(!specificBoundary.isConsistent(trainingInstance, 0)){
				System.out.print("Current Specific Boundary: ");
				System.out.println(Arrays.toString(specificBoundary.attribute));
				System.out.print("INCONSISTENT DATA: ");
				System.out.println(Arrays.toString(trainingInstance));
				return false;//Concept cannot be learned
			}
		}
		return true;
	}
	
	public ArrayList<Hypothesis> minimalSpecialization(Hypothesis h, String[] trainingInstance){
		ArrayList<Hypothesis> minSpec = new ArrayList<>();
		for(int i=0;i<totalAttributes.length;i++){
			if(h.attribute[i].equals("all")){//change ith attribute to all different values it can take and keep all other same
				for(int j=0;j<totalAttributes[i].length;j++){
					Hypothesis ms = new Hypothesis(noOfAttributes);//min specialized hypothesis
					for(int k=0;k<totalAttributes.length;k++){
						ms.attribute[k]=new String(h.attribute[k]);//copy of h
					}
					ms.attribute[i]=totalAttributes[i][j];//change ith attribute
					if(ms.isConsistent(trainingInstance, 0)){//negative instance so classification = 0
						//System.out.println("Consistent"+ Arrays.toString(ms.attribute));
						if(specificBoundary.isLessGeneralThan(ms))	minSpec.add(ms);
					}
				}
			}
		}
		return minSpec;
	}
	
	public void printSpecificBoundary(){
		System.out.println("Specific Boundary for Class "+currentPositiveClassification);
		System.out.println(Arrays.toString(specificBoundary.attribute));
	}
	
	public void printGenericBoundary(){
		System.out.println("Generic Boundary for Class "+currentPositiveClassification);
		for(Hypothesis h : genericBoundary)
			System.out.println(Arrays.toString(h.attribute));
	}
}
