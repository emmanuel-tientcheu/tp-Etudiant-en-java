import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int nombreEtudiant = 0 ;
        int choix = 0 ;
        char continuer =' ';
        double moyenneGenerale =0 ;
        Etudiant [] tableau ;
        Scanner sc = new Scanner(System.in);
        System.out.print("entrez le nombre d'etudiant de la faculete: ");
        nombreEtudiant = sc.nextInt();
        sc.nextLine();

        tableau = new Etudiant[nombreEtudiant];
        for (int i = 0 ; i <nombreEtudiant ; i++){
            tableau[i] = Etudiant.createEtudiant();
            System.out.println();
        }

        tableau = TabTrier(tableau);
        do{
            System.out.println("\t\t--Menu--");
            System.out.println("1-afficher la liste des etudiants");
            System.out.println("2-afficher le meilleur etudiant");
            System.out.println("3-afficher le pire etudiant");
            System.out.println("4-afficher la moyenne de la classe");
            System.out.println("5-afficher les etudiant ayant une note supperieur a la moyenne");
            System.out.println();
            System.out.print("faites votre choix: ");
            choix = sc.nextInt();
            sc.nextLine();
            switch(choix){
                case 1:
                    Afficher(tableau);
                    break;
                case 2 :
                    tableau[0].Afficher1();
                    break;
                case 3:
                    tableau[tableau.length-1].Afficher1();
                    break ;
                case 4:
                    moyenneGenerale = moyenne(tableau);
                    System.out.println("la moyennegenerale de la calsse est de "+moyenneGenerale);
                    break;
                case 5 :
                    EtudiantSupMoyenne(tableau, moyenneGenerale);
                    break;
                default:
                    System.out.println("choix indisponible");
                    break;
            }
            System.out.println();
            System.out.print("voulez vous continuer Y/N: ");
            continuer =sc.nextLine().toUpperCase().charAt(0);
        }while(continuer != 'N');
        
    }

    public static Etudiant[] TabTrier(Etudiant[]tableau){
        Etudiant tmp = null ;
        double moyenne ;
        int index = 0 ;

        for(int i = 0 ; i < tableau.length-1 ; i++){
            index = i;
            moyenne = tableau[i].GetMoyenne();
          for(int j = i+1 ; j<tableau.length ; j++){
              if(moyenne<tableau[j].GetMoyenne()){
                  index = j ;
              }
          }
          tmp = tableau[index];
          tableau[index] = tableau[i];
          tableau[i]=tmp; 
        }
        return tableau;
    } 
    
    public static void Afficher(Etudiant[]tableau){

        for(int i = 0 ; i < tableau.length ; i++){
           tableau[i].Afficher1();
        }
    }

    public static double moyenne(Etudiant[]tableau){
        double moyennegenerale =0 ;
        for(int i=0 ; i< tableau.length ; i++){
            moyennegenerale += tableau[i].GetMoyenne();
        }
        moyennegenerale = moyennegenerale/tableau.length;
        return moyennegenerale;
    }

    public static void EtudiantSupMoyenne(Etudiant[]tableau,double moyenneGenerale){
        for(int i=0 ; i< tableau.length ; i++){
            if(tableau[i].GetMoyenne()>moyenneGenerale){
                tableau[i].Afficher1();
            }
        }
    }

}
