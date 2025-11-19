package model;

public class CalendrierAnnuel {
	private Mois[] calendrier;
	
	public CalendrierAnnuel() {
		calendrier = new Mois[12];
		
		calendrier[1] = new Mois("Janvier",31);
		calendrier[2] = new Mois("Février",30);
		calendrier[3] = new Mois("Mars",31);
		calendrier[4] = new Mois("Avril",30);
		calendrier[5] = new Mois("Mai",31);
		calendrier[6] = new Mois("Juin",30);
		calendrier[7] = new Mois("Juillet",31);
		calendrier[8] = new Mois("Août",31);
		calendrier[9] = new Mois("Septembre",30);
		calendrier[10] = new Mois("Octobre",31);
		calendrier[11] = new Mois("Novembre",30);
		calendrier[12] = new Mois("Décembre",31);	
	}
	
	public boolean estLibre(int jour, int mois) {
		if (mois<1 || mois>12 || jour<1 || jour<calendrier[mois - 1].jour.length) {
			throw new IllegalStateException("Mois ou jour invalide");
		}
		return calendrier[mois-1].estLibre(jour);
	}
	
	private boolean reserver(int jour,int mois) {
		if(calendrier[mois-1].estLibre(jour)) {
			calendrier[mois-1].reserver(jour);
			return true;
		}else {
			return false;
		}
	}

	private static class Mois {
		private String nom;
		private Boolean[] jour;

		private Mois(String nom, int nbJour) {
			this.jour = new Boolean[nbJour];
			this.nom = nom;

			for (int i = 0; i < nbJour; i++) {
				jour[i] = false;
			}
		}

		private boolean estLibre(int jourRecherche) {
			return !jour[jourRecherche - 1];
		}

		private void reserver(int jourRecherche) {
			if (!estLibre(jourRecherche)) {
				throw new IllegalStateException("Le jour" + jourRecherche + "est déjà réservé");
			}
			jour[jourRecherche - 1] = true;
		}
	}
	
	
}
