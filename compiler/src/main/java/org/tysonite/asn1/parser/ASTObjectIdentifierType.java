/* Generated By:JJTree: Do not edit this line. ASTObjectIdentifierType.java Version 6.1 */
/* JavaCCOptions:MULTI=true,NODE_USES_PARSER=false,VISITOR=true,TRACK_TOKENS=true,NODE_PREFIX=AST,NODE_EXTENDS=,NODE_FACTORY=,SUPPORT_CLASS_VISIBILITY_PUBLIC=true */
package org.tysonite.asn1.parser;

public
class ASTObjectIdentifierType extends SimpleNode {
  public ASTObjectIdentifierType(int id) {
    super(id);
  }

  public ASTObjectIdentifierType(AsnParser p, int id) {
    super(p, id);
  }


  /** Accept the visitor. **/
  public Object jjtAccept(AsnParserVisitor visitor, Object data) {

    return
    visitor.visit(this, data);
  }
}
/* JavaCC - OriginalChecksum=f7a0706ed0e249dd819d01db7af04632 (do not edit this line) */