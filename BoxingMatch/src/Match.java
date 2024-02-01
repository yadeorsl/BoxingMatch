import java.util.Random;

public class Match {
   Fighter f1;
   Fighter f2;
   int minWeight;
   int maxWeight;
   Match(Fighter f1,Fighter f2,int minWeight,int maxWeight){
	   this.f1=f1;
	   this.f2=f2;
	   this.maxWeight=maxWeight;
	   this.minWeight=minWeight;
   }
       public void run() {
    	   if(isCheck()) {
    		   Random random=new Random();
    		   int startingPlayer=random.nextInt(2);
    		   if(startingPlayer==0) {
    			   System.out.println(this.f1.name+" is starting the match");
    		   while(this.f1.health>0&&this.f2.health>0) {
    			   System.out.println("=======New Round=======");
    			   this.f2.health=this.f1.hit(f2);
    			   if(isWin()) {
    				   break;
    			   }
    			   this.f1.health=this.f2.hit(f1);
    			   if(isWin()) {
    				   break;
    			   }
    		System.out.println(this.f1.name+"'s health: "+this.f1.health);
    		System.out.println(this.f2.name+"'s health: "+this.f2.health);
    		   }}else if(startingPlayer==1) {
    			   System.out.println(this.f2.name+" is starting the match");
    			   while(this.f2.health>0&&this.f1.health>0) {
        			   System.out.println("=======New Round=======");
        			   this.f1.health=this.f2.hit(f1);
        			   if(isWin()) {
        				   break;
        			   }
        			   this.f2.health=this.f1.hit(f2);
        			   if(isWin()) {
        				   break;
        			   }}
    		   }
    	   }else {
    		   System.out.println("Boxers' weights are not appropriate");
    	   }
       }
       boolean isCheck() {
    	   return (this.f1.weight>=minWeight&&this.f1.weight<=maxWeight)&& (this.f2.weight>=minWeight&&this.f2.weight<=maxWeight);
       }
       boolean isWin() {
    	 if(this.f1.health==0) {
    		 System.out.println(f2.name+" won");
    		 return true;
    	 }
    	 if(this.f2.health==0) {
    		 System.out.println(f1.name+" won");
    		 return true;
    	 }
    	 return false;
       }
}
