package fr.dawan.designspatterns.comportement.visitor2;

public class ProfitabilityVisitor implements Visitor<Compagny, String>{
    @Override
    public String visit(Compagny obj) {
        if(obj.getProfitability() < 0.05){
            return "bad profitability";
        }
        return "good profitability";
    }
}
