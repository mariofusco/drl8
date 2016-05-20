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

package org.drools.drl8.util;

import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ASTUtil {

    public static String parseTreeToString( ParseTree tree ) {
        StringBuilder sb = new StringBuilder();
        concatParseTree(tree, sb, 0, tree.getChildCount());
        return sb.toString();
    }

    public static String parseTreeToString( ParseTree tree, int start, int end ) {
        StringBuilder sb = new StringBuilder();
        concatParseTree(tree, sb, start, end);
        return sb.toString();
    }

    private static void concatParseTree( ParseTree tree, StringBuilder sb, int start, int end ) {
        for (int i = start; i < end; i++) {
            ParseTree child = tree.getChild( i );
            if (child instanceof TerminalNode ) {
                sb.append( child );
            } else {
                concatParseTree( child, sb, 0, child.getChildCount() );
            }
        }
    }
}
