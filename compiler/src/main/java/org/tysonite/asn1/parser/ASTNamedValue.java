/* Generated By:JJTree: Do not edit this line. ASTNamedValue.java Version 6.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.tysonite.asn1.parser;

public
class ASTNamedValue extends SimpleNode {
  public ASTNamedValue(int id) {
    super(id);
  }

  public ASTNamedValue(AsnParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AsnParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=9c5c6fceb413b7cef9e5b4e6426d73ef (do not edit this line) */
