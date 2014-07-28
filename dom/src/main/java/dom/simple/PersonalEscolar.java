package dom.simple;

import java.util.ArrayList;
import java.util.List;

import org.apache.isis.applib.DomainObjectContainer;
import org.apache.isis.applib.annotation.ActionSemantics;
import org.apache.isis.applib.annotation.Bookmarkable;
import org.apache.isis.applib.annotation.MemberOrder;
import org.apache.isis.applib.annotation.Named;
import org.apache.isis.applib.annotation.ActionSemantics.Of;

public class PersonalEscolar {

	public String getId() {
        return "personal";
    }

    public String iconName() {
        return "SimpleObject";
    }
    
    //Listar personal
    @Bookmarkable
    @ActionSemantics(Of.SAFE)
    @MemberOrder(sequence = "1")
    @Named ("Listar Personal Escolar")
    public List<Personal> listAll(){    	
    	return container.allInstances(Personal.class);
    }
    
    //Crear personal
    /*
    @MemberOrder(sequence = "2")
    @Named ("Crear Personal Escolar")
    public Personal create(){
    	
    }*/
    
    @javax.inject.Inject 
    DomainObjectContainer container;
}
