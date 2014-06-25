package dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QDireccion extends org.datanucleus.api.jdo.query.PersistableExpressionImpl<Direccion> implements PersistableExpression<Direccion>
{
    public static final QDireccion jdoCandidate = candidate("this");

    public static QDireccion candidate(String name)
    {
        return new QDireccion(null, name, 5);
    }

    public static QDireccion candidate()
    {
        return jdoCandidate;
    }

    public static QDireccion parameter(String name)
    {
        return new QDireccion(Direccion.class, name, ExpressionType.PARAMETER);
    }

    public static QDireccion variable(String name)
    {
        return new QDireccion(Direccion.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression calle;
    public final NumericExpression<Integer> numero;
    public final NumericExpression<Integer> piso;
    public final StringExpression departamento;
    public final dom.simple.QLocalidad localidad;

    public QDireccion(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.calle = new StringExpressionImpl(this, "calle");
        this.numero = new NumericExpressionImpl<Integer>(this, "numero");
        this.piso = new NumericExpressionImpl<Integer>(this, "piso");
        this.departamento = new StringExpressionImpl(this, "departamento");
        if (depth > 0)
        {
            this.localidad = new dom.simple.QLocalidad(this, "localidad", depth-1);
        }
        else
        {
            this.localidad = null;
        }
    }

    public QDireccion(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.calle = new StringExpressionImpl(this, "calle");
        this.numero = new NumericExpressionImpl<Integer>(this, "numero");
        this.piso = new NumericExpressionImpl<Integer>(this, "piso");
        this.departamento = new StringExpressionImpl(this, "departamento");
        this.localidad = new dom.simple.QLocalidad(this, "localidad", 5);
    }
}
