package dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QLocalidad extends org.datanucleus.api.jdo.query.PersistableExpressionImpl<Localidad> implements PersistableExpression<Localidad>
{
    public static final QLocalidad jdoCandidate = candidate("this");

    public static QLocalidad candidate(String name)
    {
        return new QLocalidad(null, name, 5);
    }

    public static QLocalidad candidate()
    {
        return jdoCandidate;
    }

    public static QLocalidad parameter(String name)
    {
        return new QLocalidad(Localidad.class, name, ExpressionType.PARAMETER);
    }

    public static QLocalidad variable(String name)
    {
        return new QLocalidad(Localidad.class, name, ExpressionType.VARIABLE);
    }

    public final ObjectExpression<dom.simple.Localidad.E_localidades> nombre;

    public QLocalidad(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.nombre = new ObjectExpressionImpl<dom.simple.Localidad.E_localidades>(this, "nombre");
    }

    public QLocalidad(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.nombre = new ObjectExpressionImpl<dom.simple.Localidad.E_localidades>(this, "nombre");
    }
}
