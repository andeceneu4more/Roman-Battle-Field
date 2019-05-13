package services;

import domain.individuals.Soldier;
import java.util.Comparator;

public class SoldierComparator implements Comparator<Soldier>
{
    public int compare(Soldier s1, Soldier s2)
    {
        return s1.getSoldierId() - s2.getSoldierId();
    }
}
