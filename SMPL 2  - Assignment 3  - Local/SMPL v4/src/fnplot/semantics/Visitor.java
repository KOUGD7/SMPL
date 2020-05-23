package fnplot.semantics;

import fnplot.syntax.Statement;
import fnplot.syntax.StmtDefinition;
import fnplot.syntax.StmtLet;
import fnplot.syntax.StmtSequence;
import fnplot.syntax.ExpDiv;
import fnplot.syntax.ExpLit;
import fnplot.syntax.ExpMul;
import fnplot.syntax.ExpSub;
import fnplot.syntax.ExpMod;
import fnplot.syntax.ExpVar;
import fnplot.syntax.ExpAdd;
import fnplot.syntax.ExpPow;
import fnplot.syntax.ExpFunction;
import fnplot.syntax.ExpCall;
import fnplot.syntax.ExpPlot;
import fnplot.syntax.ExpClear;
import fnplot.syntax.ExpBool;
import fnplot.syntax.ExpVector;
import fnplot.syntax.ExpSubVector;
import fnplot.syntax.ExpPair;
import fnplot.syntax.ExpIndex;
import fnplot.syntax.ExpSize;
import fnplot.syntax.ExpList;
import fnplot.syntax.ExpListCall;
import fnplot.syntax.ExpConcat;
import fnplot.syntax.ExpNull;
import fnplot.syntax.ExpLogOp;
import fnplot.syntax.ExpCompare;
import fnplot.syntax.ExpIf;
import fnplot.syntax.ArithProgram;
import fnplot.sys.FnPlotException;

/**
 * The generic Visitor interface for the Arithmetic parser
 * example.
 * @param <S> The type of the information needed by the visitor
 * @param <T> The type of result returned by the visitor 
 */
public interface Visitor<S, T> {

    // program
    public T visitArithProgram(ArithProgram p, S arg) throws FnPlotException;

    // statements

    /**
     * Visit a sequence of statements.
     * @param exp The statement sequence AST to be visited
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the given statement sequence.
     * @throws FnPlotException If an error arises while visiting the node.
     */
    public T visitStmtSequence(StmtSequence exp, S arg) throws FnPlotException ;

    /**
     * Visit an assignment (or definition) statement.
     * @param sd The assignment AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the given statement sequence.
     * @throws FnPlotException If an error arises while visiting the node.
     */
    public T visitStmtDefinition(StmtDefinition sd, S arg) throws FnPlotException;
    
    /**
     * Visit a let expression.
     * @param letExp The let AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitStmtLet(StmtLet letExp, S arg) throws FnPlotException;

    // expressions
    /**
     * Visit an add expression.
     * @param exp The addition AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpAdd(ExpAdd exp, S arg) throws FnPlotException ;
    
    /**
     * Visit a subtraction expression.
     * @param exp The subtraction AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpSub(ExpSub exp, S arg) throws FnPlotException;
    
    /**
     * Visit a multiplication expression.
     * @param exp The multiplication AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpMul(ExpMul exp, S arg) throws FnPlotException;
    
    /**
     * Visit a division expression.
     * @param exp The division AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpDiv(ExpDiv exp, S arg) throws FnPlotException;
    
    /**
     * Visit a modulo expression.
     * @param exp The modulo AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpMod(ExpMod exp, S arg) throws FnPlotException;
    
    /**
     * Visit a literal expression.
     * @param exp The literal AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpLit(ExpLit exp, S arg) throws FnPlotException;
    
    /**
     * Visit a variable reference expression.
     * @param exp The variable reference AST node to be visited.
     * @param arg The "state" to be referenced by this visitor while visiting 
     * the given node.
     * @return The result of visiting the subtree rooted at this node in the AST.
     * @throws FnPlotException If an error arises while visiting the subtree.
     */
    public T visitExpVar(ExpVar exp, S arg) throws FnPlotException;


    public T visitExpPow(ExpPow exp, S arg) throws FnPlotException;


    public T visitFnDefn(ExpFunction exp, S arg) throws FnPlotException;


    public T visitFnCall(ExpCall exp, S arg) throws FnPlotException;


    public T visitPlot(ExpPlot exp, S arg) throws FnPlotException;


    public T visitClear(ExpClear exp, S arg) throws FnPlotException;


    public T visitExpBool(ExpBool exp, S arg) throws FnPlotException;


    public T visitVector(ExpVector exp, S arg) throws FnPlotException;


    public T visitSubVector(ExpSubVector exp, S arg) throws FnPlotException;


    public T visitPair(ExpPair exp, S arg) throws FnPlotException;


    public T visitIndex(ExpIndex exp, S arg) throws FnPlotException;


    public T visitSize(ExpSize exp, S arg) throws FnPlotException;


    public T visitList(ExpList exp, S arg) throws FnPlotException;


    public T visitListCall(ExpListCall exp, S arg) throws FnPlotException;


    public T visitConcat(ExpConcat exp, S arg) throws FnPlotException;


   public T visitNull(ExpNull exp, S arg) throws FnPlotException;


   public T visitCompare(ExpCompare exp, S arg) throws FnPlotException;


   public T visitLogOp(ExpLogOp exp, S arg) throws FnPlotException;


   public T visitIf(ExpIf exp, S arg) throws FnPlotException;
 	
}
