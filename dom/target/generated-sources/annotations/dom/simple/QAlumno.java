package dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QAlumno extends dom.simple.QPersona
{
    public static final QAlumno jdoCandidate = candidate("this");

    public static QAlumno candidate(String name)
    {
        return new QAlumno(null, name, 5);
    }

    public static QAlumno candidate()
    {
        return jdoCandidate;
    }

    public static QAlumno parameter(String name)
    {
        return new QAlumno(Alumno.class, name, ExpressionType.PARAMETER);
    }

    public static QAlumno variable(String name)
    {
        return new QAlumno(Alumno.class, name, ExpressionType.VARIABLE);
    }

    public final dom.simple.QLegajo legajo;
    public final ObjectExpression<org.apache.isis.applib.DomainObjectContainer> container;

    public QAlumno(PersistableExpression parent, String name, int depth)
    {
        super(parent, name, depth);
        if (depth > 0)
        {
            this.legajo = new dom.simple.QLegajo(this, "legajo", depth-1);
        }
        else
        {
            this.legajo = null;
        }
        this.container = new ObjectExpressionImpl<org.apache.isis.applib.DomainObjectContainer>(this, "container");
    }

    public QAlumno(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.legajo = new dom.simple.QLegajo(this, "legajo", 5);
        this.container = new ObjectExpressionImpl<org.apache.isis.applib.DomainObjectContainer>(this, "container");
    }
}
