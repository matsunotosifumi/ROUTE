package route.main;
import nez.ast.CommonTree;


public class Translator {
	public static CalcTree translate(CommonTree node){
		switch (node.getTag().getSymbol()) {
		case "Source":
			return new Source(node);
		case "Funcdecl":
			return new Funcdecl(node);
		case "Arglist":
			return new Arglist(node);
		case "Arglist2":
			return new Arglist2(node);
		case "Returnlist":
			return new Returnlist(node);
		case "Return":
			return new Return(translate(node.get(0)), translate(node.get(1)));
		case "OthwiseRet":
			return new OthwiseRet(translate(node.get(0)));
		case "Returncase":
			return new Returncase(translate(node.get(0)), translate(node.get(1)));
		case "Where":
			return new Where(translate(node.get(0)));
		case "Declist":
			return new Declist(translate(node.get(0)), translate(node.get(1)));
		case "FuncCall":
			return new FuncCall(translate(node.get(0)), translate(node.get(1)));
		case "Vardecl":
			return new Vardecl(translate(node.get(0)), translate(node.get(1)));
		case "Add":
			return new Add(translate(node.get(0)), translate(node.get(1)));
		case "Sub":
			return new Add(translate(node.get(0)), new Minus(translate(node.get(1))));
		case "Mul":
			return new Mul(translate(node.get(0)), translate(node.get(1)));
		case "LessThan":
			return new LessThan(translate(node.get(0)), translate(node.get(1)));
		case "GreaterThan":
			return new GreaterThan(translate(node.get(0)), translate(node.get(1)));
		case "LessThanEquals":
			return new LessThanEquals(translate(node.get(0)), translate(node.get(1)));
		case "GreaterThanEquals":
			return new GreaterThanEquals(translate(node.get(0)), translate(node.get(1)));
		case "Equals":
			return new Equals(translate(node.get(0)), translate(node.get(1)));
		case "NotEquals":
			return new NotEquals(translate(node.get(0)), translate(node.get(1)));
		case "And":
			return new And(translate(node.get(0)),translate(node.get(1)));
		case "Or":
			return new Or(translate(node.get(0)),translate(node.get(1)));
		case "In":
			return new In(translate(node.get(0)));
		case "Out":
			return new Out(translate(node.get(0)));
		case "Int":
			return new Int(Integer.parseInt(node.toText()));
		case "Name":
			return new Name(node.toText());//これで良いのか??toStrとtoTextの違いは?
		case "True":
			return new Bool(Boolean.parseBoolean(node.toText()));
		case "False":
			return new Bool(Boolean.parseBoolean(node.toText()));
		case "Minus":
			return new Minus(translate(node.get(0)));
		case "Not":
			return new Not(translate(node.get(0)));
		default:
			break;
		}
		return null;
	}
}
