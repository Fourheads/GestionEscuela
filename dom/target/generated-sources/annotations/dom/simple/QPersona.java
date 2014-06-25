package dom.simple;

import org.datanucleus.query.typesafe.*;
import org.datanucleus.api.jdo.query.*;

public class QPersona extends org.datanucleus.api.jdo.query.PersistableExpressionImpl<Persona> implements PersistableExpression<Persona>
{
    public static final QPersona jdoCandidate = candidate("this");

    public static QPersona candidate(String name)
    {
        return new QPersona(null, name, 5);
    }

    public static QPersona candidate()
    {
        return jdoCandidate;
    }

    public static QPersona parameter(String name)
    {
        return new QPersona(Persona.class, name, ExpressionType.PARAMETER);
    }

    public static QPersona variable(String name)
    {
        return new QPersona(Persona.class, name, ExpressionType.VARIABLE);
    }

    public final NumericExpression<Integer> dni;
    public final StringExpression apellido;
    public final StringExpression nombre;
    public final StringExpression direccion;
    public final StringExpression fechaNacimiento;
    public final ObjectExpression<dom.simple.Persona.E_nacionalidad> nacionalidad;
    public final ObjectExpression<dom.simple.Persona.E_sexo> sexo;
    public final StringExpression telefono;

    public QPersona(PersistableExpression parent, String name, int depth)
    {
        super(parent, name);
        this.dni = new NumericExpressionImpl<Integer>(this, "dni");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.direccion = new StringExpressionImpl(this, "direccion");
        this.fechaNacimiento = new StringExpressionImpl(this, "fechaNacimiento");
        this.nacionalidad = new ObjectExpressionImpl<dom.simple.Persona.E_nacionalidad>(this, "nacionalidad");
        this.sexo = new ObjectExpressionImpl<dom.simple.Persona.E_sexo>(this, "sexo");
        this.telefono = new StringExpressionImpl(this, "telefono");
    }

    public QPersona(Class type, String name, org.datanucleus.api.jdo.query.ExpressionType exprType)
    {
        super(type, name, exprType);
        this.dni = new NumericExpressionImpl<Integer>(this, "dni");
        this.apellido = new StringExpressionImpl(this, "apellido");
        this.nombre = new StringExpressionImpl(this, "nombre");
        this.direccion = new StringExpressionImpl(this, "direccion");
        this.fechaNacimiento = new StringExpressionImpl(this, "fechaNacimiento");
        this.nacionalidad = new ObjectExpressionImpl<dom.simple.Persona.E_nacionalidad>(this, "nacionalidad");
        this.sexo = new ObjectExpressionImpl<dom.simple.Persona.E_sexo>(this, "sexo");
        this.telefono = new StringExpressionImpl(this, "telefono");
    }
}
