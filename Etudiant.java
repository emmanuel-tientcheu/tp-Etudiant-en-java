import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Etudiant{

    private String matricule ;
    private String name ;
    private char genre ;
    private Date dateNaissance;
    private double moyenne ;

    public Etudiant(String matricule, String name, char genre, Date dateNaissance, double moyenne){
        this.matricule = matricule;
        this.name = name;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.moyenne = moyenne;
    }

    public void Afficher1(){
        System.out.println("matricule = " + matricule + ", name = " + name + ", genre = " + genre + ", dateNaissace = " + dateNaissance + ", moyenne = " + moyenne);
    }

    public int CalculerAge(){
        
        return new Date().getYear() - dateNaissance.getYear();
    }

    public double Bonifier(double bonus){
        moyenne += bonus;
        return moyenne ; 
    }

    public double GetMoyenne(){
        return moyenne;
    }

    public static Etudiant createEtudiant(){
        Scanner sc = new Scanner(System.in);
        Etudiant e = null;
        String nomEtudiant = " ";
        while(nomEtudiant.length()<3){
            System.out.print("Entrez le nom de l'etudiant: ");
            nomEtudiant = sc.nextLine();
        }

        String matricule="";
        while(matricule.length()<7){
            System.out.print("entrez le matricule: ");
            matricule = sc.nextLine();
        }

        char genre=' ';
        while(genre!='M' && genre!='F'){
            System.out.print("entrez le genre de l'etudiant: ");
            //System.out.print(genre);
            genre = sc.nextLine().toUpperCase().charAt(0);
        }

        Date date = null;
        boolean goodDate = false;
        while(!goodDate){
            String dateInString ="";
            System.out.print("entrez une date de naissance de l'etudiant sous le format dd/mm/yyyy: ");
            dateInString = sc.nextLine();
            SimpleDateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

            try {
                date = formatter.parse(dateInString);
                goodDate = true;
            }catch(Exception ex){}
        }
        double moyenne = -1;
        while(moyenne<0){
            System.out.print("entrez la note de l'etudiant: ");
            moyenne = sc.nextDouble();
            sc.nextLine();
        }
        e= new Etudiant (matricule,nomEtudiant,genre,date,moyenne);
        return e;
    }
    
}