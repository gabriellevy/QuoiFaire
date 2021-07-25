import java.util.Comparator;

public class Activite  implements Comparator< Activite > {

    String nom_;
    int duree_min_;
    int duree_max_;
    int constructif_;
    int energie_physique_;
    int energie_mentale_;
    int defoulement_;
    int relaxation_;

    public int score_ = 0;

    public Activite(String nom_, int duree_min_, int duree_max_, int constructif_, int energie_physique_, int energie_mentale_, int defoulement_, int relaxation_) {
        this.nom_ = nom_;
        this.duree_min_ = duree_min_;
        this.duree_max_ = duree_max_;
        this.constructif_ = constructif_;
        this.energie_physique_ = energie_physique_;
        this.energie_mentale_ = energie_mentale_;
        this.defoulement_ = defoulement_;
        this.relaxation_ = relaxation_;
    }

    /**
     * plus el score est bas plus l'ctivité est recommandée
     * @param tempsDispo
     * @param constructif
     * @param energie_physique
     * @param energie_mentale
     * @param defoulement
     * @param relaxation
     * @return
     */
    public void CalculerScore(int tempsDispo, int constructif, int energie_physique, int energie_mentale, int defoulement, int relaxation) {
        if (tempsDispo < duree_min_ )
            score_ = -1;
        else
            score_ = Math.abs(constructif - constructif_) +
                Math.abs(energie_physique - energie_physique_) +
                Math.abs(energie_mentale - energie_mentale_) +
                Math.abs(defoulement - defoulement_) +
                Math.abs(relaxation - relaxation_);
    }

    @Override
    public int compare(Activite o1, Activite o2) {
        return o1.score_ - o2.score_;
    }
}
