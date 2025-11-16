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
package org.bpy.score.rcp.view;

import org.apache.commons.lang3.StringUtils;
import org.bpy.score.engine.manager.RunnerPositionManager;
import org.bpy.score.engine.manager.lineup.LineupManager;
import org.bpy.score.engine.stats.StatisticEngine;
import org.bpy.score.engine.util.EngineConstants;
import org.bpy.score.engine.util.ScoreGameEngine;
import org.bpy.score.game.game.Game;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.ControlListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.wb.swt.SWTResourceManager;

import org.eclipse.wb.swt.ResourceManager;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;

/**
 * This view show the base occupation by the offensive team, and name of the pitcher and catcher. 
 * 
 * @author Patrick BRIAND
 *
 */
public class FieldViewOccupation extends AbstractContextualPanel {

	/** Bundle name */
	public static final String BUNDLE_NAME = "org.bpy.score.rcp";
	/** Font name */
	public static final String ARIAL_FONT = "Arial Black";
	
	/** ID of the view */
	public static final String ID = "org.bpy.score.rcp.view.FeildViewOccupation"; //$NON-NLS-1$
	/** Label for the second base position */
	private Label secondBasePosition;
	/** Label for the batter position */
	private Label marblePosition;
	/** Label for the third base position */
	private Label thirdBasePosition;
	/** Label for the first base position */
	private Label firstBasePosition;
	/** Label for the pitcher name  */
	private Label pitcherName;
	/** Label for the catcher name  */
	private Label catcherName;

	/** reference on field occupation panel */
	private Composite fieldOccupationPane;

	/** Current image display */
	private Image currentImage;
	/** All base free image */
	private Image image000;
	/** first base occupied image */ 
	private Image image001;
	/** second base occupied image */ 
	private Image image010;
	/** first and second base occupied image */ 
	private Image image011;
	/** Third base occupied image */ 
	private Image image100;
	/** first and third base occupied image */ 
	private Image image101;
	/** second and third base occupied image */ 
	private Image image110;
	/** All bases occupied image */ 
	private Image image111;
	
	/**
	 * Constructor of the class
	 */
	public FieldViewOccupation() {
		super();
	}

	/**
	 * Create contents of the view part.
	 *
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {

		image000 = ResourceManager.getPluginImage(BUNDLE_NAME,"icons/baseball-field-clipart-000.png"); //$NON-NLS-1$
		image001 = ResourceManager.getPluginImage(BUNDLE_NAME,"icons/baseball-field-clipart-001.png"); //$NON-NLS-1$
		image010 = ResourceManager.getPluginImage(BUNDLE_NAME,"icons/baseball-field-clipart-010.png"); //$NON-NLS-1$
		image011 = ResourceManager.getPluginImage(BUNDLE_NAME,"icons/baseball-field-clipart-011.png"); //$NON-NLS-1$
		image100 = ResourceManager.getPluginImage(BUNDLE_NAME,"icons/baseball-field-clipart-100.png"); //$NON-NLS-1$
		image101 = ResourceManager.getPluginImage(BUNDLE_NAME,"icons/baseball-field-clipart-101.png"); //$NON-NLS-1$
		image110 = ResourceManager.getPluginImage(BUNDLE_NAME,"icons/baseball-field-clipart-110.png"); //$NON-NLS-1$
		image111 = ResourceManager.getPluginImage(BUNDLE_NAME,"icons/baseball-field-clipart-111.png"); //$NON-NLS-1$
		
	
		currentImage = image000;

		Composite container = new Composite(parent, SWT.NONE);
		container.setSize(new Point(300, 500));
		container.setLayout(new FormLayout());

		fillFieldOccupationPane(container);

		createActions();
		initializeToolBar();
		initializeMenu();

		initializeListener(parent);
	}

	/**
	 * Initialize the listener
	 * @param parent
	 */
	protected void initializeListener(Composite parent) {
		
		parent.addControlListener(new ControlListener() {
			
			@Override
			public void controlResized(ControlEvent e) {

				Point point = parent.getSize();
				if ((point.x != 300 ) && (point.y != 275)) {
					parent.setSize(300, 275);
				}
			}
			
			@Override
			public void controlMoved(ControlEvent e) {
				// Nothing to do
			}
		});
		
		super.initializeListener();
	}

	/**
	 * Fill the view
	 * 
	 * @param container reference to the parent container
	 */
	private void fillFieldOccupationPane(Composite container) {
		fieldOccupationPane = new Composite(container, SWT.NONE);
		FormData fdFieldOccupationPane = new FormData();
		fdFieldOccupationPane.bottom = new FormAttachment(0, 275);
		fdFieldOccupationPane.top = new FormAttachment(0);
		fdFieldOccupationPane.left = new FormAttachment(0);
		fieldOccupationPane.setLayoutData(fdFieldOccupationPane);
		fieldOccupationPane.setBackgroundImage(resize(300, 275));

		marblePosition = new Label(fieldOccupationPane, SWT.NONE);
		marblePosition.setLocation(0, 215);
		marblePosition.setSize(300, 22);
		marblePosition.setFont(SWTResourceManager.getFont(ARIAL_FONT, 9, SWT.BOLD));
		marblePosition.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		marblePosition.setAlignment(SWT.CENTER);
		marblePosition.setText("");

		secondBasePosition = new Label(fieldOccupationPane, SWT.NONE);
		secondBasePosition.setLocation(0, 37);
		secondBasePosition.setSize(300, 22);
		secondBasePosition.setFont(SWTResourceManager.getFont(ARIAL_FONT, 9, SWT.BOLD));
		secondBasePosition.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		secondBasePosition.setAlignment(SWT.CENTER);
		secondBasePosition.setText("");

		thirdBasePosition = new Label(fieldOccupationPane, SWT.NONE);
		thirdBasePosition.setLocation(0, 120);
		thirdBasePosition.setSize(137, 22);
		thirdBasePosition.setFont(SWTResourceManager.getFont(ARIAL_FONT, 9, SWT.BOLD));
		thirdBasePosition.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		thirdBasePosition.setText("");

		firstBasePosition = new Label(fieldOccupationPane, SWT.NONE);
		firstBasePosition.setLocation(153, 120);
		firstBasePosition.setSize(147, 22);
		firstBasePosition.setFont(SWTResourceManager.getFont(ARIAL_FONT, 9, SWT.BOLD));
		firstBasePosition.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		firstBasePosition.setAlignment(SWT.RIGHT);

		pitcherName = new Label(fieldOccupationPane, SWT.CENTER);
		pitcherName.setFont(SWTResourceManager.getFont(ARIAL_FONT, 9, SWT.BOLD));
		pitcherName.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_MAGENTA));
		pitcherName.setBounds(0, 171, 300, 22);
		pitcherName.setText("Pitcher");

		catcherName = new Label(fieldOccupationPane, SWT.CENTER);
		catcherName.setText("Catcher");
		catcherName.setForeground(SWTResourceManager.getColor(SWT.COLOR_DARK_MAGENTA));
		catcherName.setFont(SWTResourceManager.getFont(ARIAL_FONT, 9, SWT.BOLD));
		catcherName.setBounds(0, 253, 300, 22);
	}

	/**
	 * Resize the image in the view 
	 * 
	 * @param width width of the view
	 * @param height height of the view
	 * 
	 * @return scaled image
	 */
	private Image resize(int width, int height) {
		Image scaled = new Image(Display.getDefault(), width, height);
		GC gc = new GC(scaled);
		gc.setAntialias(SWT.ON);
		gc.setInterpolation(SWT.HIGH);
		gc.drawImage(currentImage, 0, 0, currentImage.getBounds().width, currentImage.getBounds().height, 0, 0,	width, height);
		gc.dispose();
		return scaled;
	}

	@Override
	public void clearPanel() {
		setLabelValue(marblePosition, StringUtils.EMPTY);
		setLabelValue(firstBasePosition, StringUtils.EMPTY);
		setLabelValue(secondBasePosition, StringUtils.EMPTY);
		setLabelValue(thirdBasePosition, StringUtils.EMPTY);
	}

	@Override
	public void updatePanel(Game game, ScoreGameEngine scoreGameEngine, StatisticEngine statisticEngine) {
		RunnerPositionManager runnerPositionManager = scoreGameEngine.getScoreGameManager().getRunnerPositionManager();

		currentImage = getCurrentImage(runnerPositionManager);
		Image oldImage = fieldOccupationPane.getBackgroundImage();
		fieldOccupationPane.setBackgroundImage(resize(300, 275));
		oldImage.dispose();
		
		setLabelValue(marblePosition, getRunnerAtPosition(runnerPositionManager, 0));
		setLabelValue(firstBasePosition, getRunnerAtPosition(runnerPositionManager, 1));
		setLabelValue(secondBasePosition, getRunnerAtPosition(runnerPositionManager, 2));
		setLabelValue(thirdBasePosition, getRunnerAtPosition(runnerPositionManager, 3));
		
		
		String currentTeam = scoreGameEngine.getActionsManager().getLastCurrentTeam();
		if (currentTeam != null) {
			LineupManager currentLineup = (EngineConstants.HOMETEAM.equals(currentTeam)
					? scoreGameEngine.getActionsManager().getVisitorLineup()
					: scoreGameEngine.getActionsManager().getHometeamLineup());
			
			if (currentLineup.getCurrentPitcher() != null) {
				String name = currentLineup.getCurrentPitcher().getPlayerDescription().getName();
				setLabelValue(pitcherName, name);
			}
			if (currentLineup.getCurrentCatcher() != null) {
				String name = currentLineup.getCurrentCatcher().getPlayerDescription().getName();
				setLabelValue(catcherName, name);
			}	
		} else {
			setLabelValue(pitcherName, "");
			setLabelValue(catcherName, "");
		}
	}

	/**
	 * Get image in function of the base occupation
	 * 
	 * @param runnerPositionManager Reference on the runner position manager
	 * 
	 * @return current image to display
	 */
	private Image getCurrentImage(RunnerPositionManager runnerPositionManager) {
		String base1 = getRunnerAtPosition(runnerPositionManager, 1);
		String base2 = getRunnerAtPosition(runnerPositionManager, 2);
		String base3 = getRunnerAtPosition(runnerPositionManager, 3);
		
		String key = (base3.isEmpty() ? "0" : "1"); //$NON-NLS-1$ //$NON-NLS-2$
		key = key + (base2.isEmpty()? "0" : "1"); //$NON-NLS-1$ //$NON-NLS-2$
		key = key + (base1.isEmpty() ? "0" : "1"); //$NON-NLS-1$ //$NON-NLS-2$
		
		switch (key) {
		case "000" : return image000; //$NON-NLS-1$ 
		case "001" : return image001; //$NON-NLS-1$
		case "010" : return image010; //$NON-NLS-1$
		case "011" : return image011; //$NON-NLS-1$
		case "100" : return image100; //$NON-NLS-1$
		case "101" : return image101; //$NON-NLS-1$
		case "110" : return image110; //$NON-NLS-1$
		case "111" : return image111; //$NON-NLS-1$
		default    : return image000; //$NON-NLS-1$
		}
	}

	/**
	 * Get current runner on base. 
	 * 
	 * @param runnerPositionManager Reference on the runner position manager
	 * @param position base number
	 * 
	 * @return Runner name, <b>empty string</b> if base free
	 */
	private String getRunnerAtPosition(RunnerPositionManager runnerPositionManager, int position) {
		try {
			return runnerPositionManager.getPlayerAtPosition(position).getPlayerDescription().getName();
		} catch (NullPointerException ex) {
			return StringUtils.EMPTY;
		}
	}

	/**
	 * Create the actions.
	 */
	private void createActions() {
		// Create the actions
	}

	/**
	 * Initialize the toolbar.
	 */
	private void initializeToolBar() {
		// nothing to do
	}

	/**
	 * Initialize the menu.
	 */
	private void initializeMenu() {
		// nothing to do
	}

	@Override
	public void setFocus() {
		// Set the focus
	}
}
