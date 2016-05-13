/*
 * Copyright 2005 JBoss Inc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.drools.drl8;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.drools.drl8.antlr4.DRL8Lexer;
import org.drools.drl8.antlr4.DRL8Parser;

import java.io.File;

public class Main {

    private static final String TEST_FILE = "src/test/resources/examples/Test.java";

    public static void main( String[] args ) throws Exception {
        File file = new File( TEST_FILE);

        ANTLRFileStream antlrFileStream = new ANTLRFileStream( file.getAbsolutePath(), "UTF-8");
        DRL8Lexer lexer = new DRL8Lexer( antlrFileStream );
        final CommonTokenStream tokens = new CommonTokenStream( lexer );

        DRL8Parser parser = new DRL8Parser( tokens);
        parser.setErrorHandler(new BailErrorStrategy() );

        SourceGenerator sourceGenerator = new SourceGenerator();
        parser.addParseListener( sourceGenerator );
        ParserRuleContext parserRuleContext = parser.compilationUnit();

        System.out.println( sourceGenerator.getSource() );
    }

}