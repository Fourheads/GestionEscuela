package dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QTarjeta extends org.datanucleus.api.jdo.query.PersistableExpressionImpl<Tarjeta> implements PersistableExpression<Tarjeta>
{
    public static final QTarjeta jdoCandidate = candidate("this");

    public static QTarjeta candidate(String name)
    {
        return new QTarjeta(null, name, 5);
    }

    public static QTarjeta candidate()
    {
        return jdoCandidate;
    }

    public static QTarjeta parameter(String name)
    {
        return new QTarjeta(Tarjeta.class, name, ExpressionType.PARAMETER);
    }

    public static QTarjeta variable(String name)
    {
        return new QTarjeta(Tarjeta.class, name, ExpressionType.VARIABLE);
    }

    public final StringExpression titulo;
    public final StringExpression comentarios;
    public final ObjectExpression<dom.simple.Tarjeta.ECategoria> categoria;

    public QTarjeta(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.titulo = new StringExpressionImpl(this, "titulo");
        this.comentarios = new StringExpressionImpl(this, "comentarios");
        this.categoria = new ObjectExpressionImpl<dom.simple.Tarjeta.ECategoria>(this, "categoria");
    }

    public QTarjeta(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.titulo = new StringExpressionImpl(this, "titulo");
        this.comentarios = new StringExpressionImpl(this, "comentarios");
        this.categoria = new ObjectExpressionImpl<dom.simple.Tarjeta.ECategoria>(this, "categoria");
    }
}
