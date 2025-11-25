/*
 * European Scoring Tool For Baseball
 * Copyright (C) 2020  Patrick BRIAND
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.bpy.score.game.ui;

import org.bpy.score.internationalization.game.Messages;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.xtext.ide.editor.syntaxcoloring.HighlightingStyles;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfigurationAcceptor;
import org.eclipse.xtext.ui.editor.utils.TextStyle;

/**
 * The class define the coloring style 
 *   
 * @author Patrick BRIAND
 *
 */
public class GameHighlightingConfiguration implements IHighlightingConfiguration {

	/** Constant for coloring Keyword */
	public static final String KEYWORD_ID = HighlightingStyles.KEYWORD_ID;
	/** Constant for coloring punctuation */
	public static final String PUNCTUATION_ID = HighlightingStyles.PUNCTUATION_ID;
	/** Constant for coloring Comments */
	public static final String COMMENT_ID = HighlightingStyles.COMMENT_ID;
	/** Constant for coloring String */
	public static final String STRING_ID = HighlightingStyles.STRING_ID;
	/** Constant for coloring Number */
	public static final String NUMBER_ID = HighlightingStyles.NUMBER_ID;
	/** Constant for coloring Default  */
	public static final String DEFAULT_ID = HighlightingStyles.DEFAULT_ID;
	/** Constant for coloring Invalid token  */
	public static final String INVALID_TOKEN_ID = HighlightingStyles.INVALID_TOKEN_ID;
	/** Constant for coloring Task  */
	public static final String TASK_ID = HighlightingStyles.TASK_ID;

	/** Constant for coloring put outs  */
	public static final String PUTOUT_ID = "POUTOUT_ID"; //$NON-NLS-1$
	/** Constant for coloring Advance  */
	public static final String ADVANCE_ID = "ADVANCE_ID"; //$NON-NLS-1$
	/** Constant for coloring Pitchs  */
	public static final String PITCHE_ID = "PITCHE_ID"; //$NON-NLS-1$

	@Override
	public void configure(IHighlightingConfigurationAcceptor acceptor) {
		acceptor.acceptDefaultHighlighting(KEYWORD_ID, Messages.GameHighlightingConfiguration_keyword, keywordTextStyle()); 
		acceptor.acceptDefaultHighlighting(PUNCTUATION_ID, Messages.GameHighlightingConfiguration_PunctuationCharacter, punctuationTextStyle());
		acceptor.acceptDefaultHighlighting(COMMENT_ID, Messages.GameHighlightingConfiguration_Comment, commentTextStyle());
		acceptor.acceptDefaultHighlighting(TASK_ID, Messages.GameHighlightingConfiguration_TaskTag, taskTextStyle()); 
		acceptor.acceptDefaultHighlighting(STRING_ID, Messages.GameHighlightingConfiguration_String, stringTextStyle()); 
		acceptor.acceptDefaultHighlighting(NUMBER_ID, Messages.GameHighlightingConfiguration_Number, numberTextStyle()); 
		acceptor.acceptDefaultHighlighting(DEFAULT_ID, Messages.GameHighlightingConfiguration_default, defaultTextStyle()); 
		acceptor.acceptDefaultHighlighting(INVALID_TOKEN_ID, Messages.GameHighlightingConfiguration_InvalidSymbol, errorTextStyle()); 

		acceptor.acceptDefaultHighlighting(PUTOUT_ID, Messages.GameHighlightingConfiguration_PutOuts, putoutTextStyle()); 
		acceptor.acceptDefaultHighlighting(ADVANCE_ID, Messages.GameHighlightingConfiguration_Advances, advanceTextStyle()); 
		acceptor.acceptDefaultHighlighting(PITCHE_ID, Messages.GameHighlightingConfiguration_Pitches, pitchTextStyle()); 
	}

	/**
	 * get the default style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle defaultTextStyle() {
		return new TextStyle();
	}

	/**
	 * get the error style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle errorTextStyle() {
		return defaultTextStyle().copy();
	}

	/**
	 * get the number style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle numberTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(125, 125, 125));
		return textStyle;
	}

	/**
	 * get the String style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle stringTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(42, 0, 255));
		return textStyle;
	}

	/**
	 * get the comment style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle commentTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(63, 127, 95));
		return textStyle;
	}

	/**
	 * get the task style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle taskTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 159, 191));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the keyword style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle keywordTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(127, 0, 85));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the punctuation style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle punctuationTextStyle() {
		return defaultTextStyle().copy();
	}

	/**
	 * get the put out style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle putoutTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(255, 0, 0));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the advance style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle advanceTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 128, 0));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}

	/**
	 * get the pitchs style.
	 * 
	 * @return TextStyle object
	 */
	private TextStyle pitchTextStyle() {
		TextStyle textStyle = defaultTextStyle().copy();
		textStyle.setColor(new RGB(0, 0, 0));
		textStyle.setStyle(SWT.BOLD);
		return textStyle;
	}
}
