package org.tysonite.asn1.gen.visitor;

import org.tysonite.asn1.gen.ContentProvider;
import org.tysonite.asn1.gen.DoNothingASTVisitor;
import org.tysonite.asn1.gen.GeneratorContext;
import org.tysonite.asn1.gen.Main;
import org.tysonite.asn1.gen.utils.CodeBuilder;
import org.tysonite.asn1.gen.utils.GenerationUtils;
import org.tysonite.asn1.gen.utils.VisitorUtils;
import org.tysonite.asn1.parser.ASTBuiltinType;
import org.tysonite.asn1.parser.ASTElementType;
import org.tysonite.asn1.parser.ASTSetOrSequenceType;

public class SequenceConstructorDefinition extends DoNothingASTVisitor implements ContentProvider {

   private final CodeBuilder builder = new CodeBuilder();
   private final GeneratorContext context;

   public SequenceConstructorDefinition(final GeneratorContext context) {
      this.context = context;
   }

   @Override
   public Object visit(ASTBuiltinType node, Object data) {
      return node.childrenAccept(this, data);
   }

   @Override
   public Object visit(ASTSetOrSequenceType node, Object data) {
      return node.childrenAccept(this, data);
   }

   @Override
   public Object visit(ASTElementType node, Object data) {
      final String elementTypeName = "_"
              + GenerationUtils.asCPPToken(node.jjtGetFirstToken().toString()) + "_Type";

      // internal types
      VisitorUtils.visitChildsAndAccept(builder, node,
              new IntegerConstructorDefinition(context, elementTypeName),
              new OctetStringConstructorDefinition(context, elementTypeName));

      if (VisitorUtils.visitChildsAndAccept(null, node, new IsSimpleType(context))) {
         VisitorUtils.visitChildsAndAccept(builder, node,
                 new SimpleTypeConstructorDefinition(context, elementTypeName));
      }

      // only for XER
      if (context.getCommandLine().hasOption(Main.METHOD_XER.getOpt())) {
         builder.append("#if defined(ASN1_ENABLE_XER)").newLine();
         builder.append(2, elementTypeName).append(".").append("setTypeName(\"")
                 .append(node.jjtGetFirstToken().toString()).append("\");");
         builder.newLine();
         builder.append("#endif // ASN1_ENABLE_XER");
         builder.newLine();
      }

      return data;
   }

   public String getContent() {
      return builder.toString();
   }

   public boolean hasValuableContent() {
      return !builder.toString().isEmpty();
   }
}
