package dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QLegajo extends org.datanucleus.api.jdo.query.PersistableExpressionImpl<Legajo> implements PersistableExpression<Legajo>
{
    public static final QLegajo jdoCandidate = candidate("this");

    public static QLegajo candidate(String name)
    {
        return new QLegajo(null, name, 5);
    }

    public static QLegajo candidate()
    {
        return jdoCandidate;
    }

    public static QLegajo parameter(String name)
    {
        return new QLegajo(Legajo.class, name, ExpressionType.PARAMETER);
    }

    public static QLegajo variable(String name)
    {
        return new QLegajo(Legajo.class, name, ExpressionType.VARIABLE);
    }

    public final CollectionExpression tarjetas;
    public final StringExpression propietario;

    public QLegajo(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.tarjetas = new CollectionExpressionImpl(this, "tarjetas");
        this.propietario = new StringExpressionImpl(this, "propietario");
    }

    public QLegajo(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.tarjetas = new CollectionExpressionImpl(this, "tarjetas");
        this.propietario = new StringExpressionImpl(this, "propietario");
    }
}
