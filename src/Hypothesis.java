public class Hypothesis {
	String[] attribute;

	public Hypothesis(int noOfAttr){
		attribute = new String[noOfAttr];
	}
	
	//currentPositiveClassification is the value from 1 to 7 for which we are finding concept hypothesis
	public boolean isConsistent(String[] trainingInstance, int classification){
		int predictedClassification = predictClass(trainingInstance);
		return predictedClassification == classification;
	}
	
	public int predictClass(String[] trainingInstance){
		for(int i = 0; i < attribute.length; i++){
			if(attribute[i].equals("none"))	return 0;
			if(attribute[i].equals("all"))	continue;
			if(!attribute[i].equals(trainingInstance[i]))	return 0;
		}
		return 1;
	}
	
	public int score(String s){//more general --> more score
		if(s.equals("all"))	return 2;
		else if (s.equals("none"))	return 0;
		else return 1;
	}
	
	//generality: all > value > none
	public boolean isLessGeneralThan(Hypothesis h){
		int less = 0;
		for(int i = 0; i < attribute.length; i++){
			int s1 = score(this.attribute[i]), s2 = score(h.attribute[i]);
			if(s1 > s2)	return false;
			else if(s1 == s2){
				if(s1==1)	if(!this.attribute[i].equals(h.attribute[i]))	return false;
			}else	less++;
		}
		return less>0;
	}
}