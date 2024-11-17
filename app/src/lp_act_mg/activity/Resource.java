package lp_act_mg.activity;

import user_role_management.user_management.Student;

public class Resource extends Activity {

    public final String RESOURCE = "Resource";
    private String resourceType;
    private String link;

    public Resource(String resourceType, String link, String title, String description, String difficultyLevel, int expectedDuration, boolean mandatory) {
        super(title, description, difficultyLevel, expectedDuration, mandatory);
        this.resourceType = resourceType;
        this.link = link;
    }

    public String getResourceType() {
        return resourceType;
    }

    public String getLink() {
        return link;
    }

    @Override
    public boolean isCompleted(Student student) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void showActivity() {
        // TODO Auto-generated method stub
        System.out.println("Titulo: " + this.title);
        System.out.println("Descripcion: " + this.description);
        System.out.println("Nivel de Dificultad: " + this.difficultyLevel);
        System.out.println("Tiempo de duracion: " + this.expectedDuration);
        System.out.println("Tipo Recurso: " + this.resourceType);
        System.out.println("Link: " + this.link);
    }

}
