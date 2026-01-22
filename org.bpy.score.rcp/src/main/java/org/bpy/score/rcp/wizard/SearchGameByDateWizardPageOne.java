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
package org.bpy.score.rcp.wizard;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bpy.score.game.game.Game;
import org.bpy.score.internationalization.rcp.Messages;
import org.eclipse.jface.wizard.WizardDialog;
import org.eclipse.jface.wizard.WizardPage;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.DateTime;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.swt.widgets.TableItem;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;

/**
 * Page one of the search function by date
 * 
 * @author Patrick BRIAND
 *
 */
public class SearchGameByDateWizardPageOne extends WizardPage {

   /** Logger of the class */
   public static final Logger logger = Logger.getLogger(SearchGameByDateWizardPageOne.class.getSimpleName());

   /** End DateTime picker widget */
   private DateTime endDatePicker;
   /** Start DateTime picker widget */
   private DateTime startDatePicker;
   /** Table which contains games */
   private Table table;

   /** Reference to the owner of the page */
   private SearchGameByDateWizard searchGameForDateWizard;

   /** List of games by date */
   private HashMap<Date, List<Game>> gamesByDate;
   /** SWT button for a range selection */
   private Button btnRangeSelection;
   /** SWT Label for end date picker */
   private Label endLabelDatePicker;

   /**
    * Create the wizard.
    * 
    * @param searchGameForDateWizard Reference to the owner of the page
    * @param currentCategory         Current selected category
    */
   public SearchGameByDateWizardPageOne(SearchGameByDateWizard searchGameForDateWizard, String currentCategory) {
      super("wizardPage"); //$NON-NLS-1$
      setMessage(Messages.SearchGameByDateWizardPageOne_PageMessage);
      setTitle(Messages.SearchGameByDateWizardPageOne_PageTitle);
      setDescription(Messages.SearchGameByDateWizardPageOne_PageDescription);

      this.searchGameForDateWizard = searchGameForDateWizard;
   }

   /**
    * Create contents of the wizard.
    * 
    * @param parent reference to the parent
    */
   public void createControl(Composite parent) {
      Composite container = new Composite(parent, SWT.NONE);

      setControl(container);
      container.setLayout(new GridLayout(7, false));

      Label lblDateSelection = new Label(container, SWT.NONE);
      lblDateSelection.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
      lblDateSelection.setText(Messages.SearchGameByDateWizardPageOne_dateSelection);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);

      btnRangeSelection = new Button(container, SWT.CHECK);
      btnRangeSelection.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 2, 1));
      btnRangeSelection.setText(Messages.SearchGameByDateWizardPageOne_btnRange_text);
      btnRangeSelection.setSelection(true);
      btnRangeSelection.addSelectionListener(new SelectionAdapter() {
         @Override
         public void widgetSelected(SelectionEvent e) {
            manageRangeSelection();
         }
      });

      Label lblNewLabel = new Label(container, SWT.NONE);
      GridData gdLblNewLabel = new GridData(SWT.FILL, SWT.CENTER, false, false, 1, 1);
      gdLblNewLabel.widthHint = 40;
      lblNewLabel.setLayoutData(gdLblNewLabel);
      lblNewLabel.setText(" "); //$NON-NLS-1$
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);

      Label lblNewLabel2 = new Label(container, SWT.NONE);
      lblNewLabel2.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, false, 1, 1));
      lblNewLabel2.setText(" "); //$NON-NLS-1$

      Label lblDbutDeLa = new Label(container, SWT.NONE);
      lblDbutDeLa.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      lblDbutDeLa.setText(Messages.SearchGameByDateWizardPageOne_StartDateLabel);

      startDatePicker = new DateTime(container, SWT.BORDER | SWT.DATE | SWT.DROP_DOWN);
      startDatePicker.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      new Label(container, SWT.NONE);

      endLabelDatePicker = new Label(container, SWT.NONE);
      endLabelDatePicker.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      endLabelDatePicker.setText(Messages.SearchGameByDateWizardPageOne_EndDateLabel);

      endDatePicker = new DateTime(container, SWT.BORDER | SWT.DATE | SWT.DROP_DOWN);
      endDatePicker.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));

      Button btnSearch = new Button(container, SWT.NONE);
      btnSearch.addSelectionListener(new SelectionAdapter() {
         @Override
         public void widgetSelected(SelectionEvent e) {
            updateTable();
         }
      });
      btnSearch.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, false, 1, 1));
      btnSearch.setText(Messages.SearchGameByDateWizardPageOne_btnSearch_text);
      new Label(container, SWT.NONE);

      Label lblNewLabel1 = new Label(container, SWT.NONE);
      lblNewLabel1.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 5, 1));
      lblNewLabel1.setText(" ");
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);

      Label label = new Label(container, SWT.NONE);
      label.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, false, false, 3, 1));
      label.setText(Messages.SearchGameByDateWizardPageOne_listOfGames);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);
      new Label(container, SWT.NONE);

      table = new Table(container, SWT.BORDER | SWT.FULL_SELECTION);
      table.addSelectionListener(new SelectionAdapter() {
         @Override
         public void widgetSelected(SelectionEvent e) {
            checkPageCompleted();
         }
      });
      table.setLayoutData(new GridData(SWT.FILL, SWT.FILL, false, true, 7, 1));
      table.setHeaderVisible(true);
      table.setLinesVisible(true);
      table.addListener(SWT.MouseDoubleClick, e -> {
 
         if (getWizard().getContainer() instanceof WizardDialog dialog) {
            Button finishButton = dialog.getShell().getDefaultButton();

            if (finishButton != null && !finishButton.isDisposed()) {
               finishButton.notifyListeners(SWT.Selection, new Event());
            }
         }
      });

      TableColumn tblclmnDate = new TableColumn(table, SWT.NONE);
      tblclmnDate.setWidth(100);
      tblclmnDate.setText(Messages.SearchGameByDateWizardPageOne_DateColumnTable);

      TableColumn tblclmnCode = new TableColumn(table, SWT.NONE);
      tblclmnCode.setWidth(100);
      tblclmnCode.setText(Messages.SearchGameByDateWizardPageOne_CodeColumnTable);

      TableColumn tblclmnDescription = new TableColumn(table, SWT.NONE);
      tblclmnDescription.setWidth(341);
      tblclmnDescription.setText(Messages.SearchGameByDateWizardPageOne_DescriptionColumnTable);

      createDataToDisplay();
      initPageContent();
      checkPageCompleted();
   }

   /**
    * Call when the button allow range selection is used.
    */
   protected void manageRangeSelection() {
      endDatePicker.setVisible(btnRangeSelection.getSelection());
      endLabelDatePicker.setVisible(btnRangeSelection.getSelection());
      updateTable();
   }

   /**
    * Populate widgets with data.
    * 
    */
   private void initPageContent() {
      initDateLimits();
      updateTable();
   }

   /**
    * Create a data structure for search games by dates.
    */
   private void createDataToDisplay() {
      List<Game> games = searchGameForDateWizard.getGameDataParser().getGames();
      gamesByDate = new HashMap<>();

      SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy"); //$NON-NLS-1$

      for (Game game : games) {
         String strDate = game.getDescription().getDate();
         try {
            Date gameDate = dateFormat.parse(strDate);
            if (gamesByDate.containsKey(gameDate)) {
               gamesByDate.get(gameDate).add(game);
            } else {
               List<Game> listOfGames = new ArrayList<>();
               listOfGames.add(game);
               gamesByDate.put(gameDate, listOfGames);
            }

         } catch (ParseException e) {
            logger.log(Level.SEVERE, e.getMessage());
         }
      }
   }

   /**
    * Check that the page is correctly fill
    */
   private void checkPageCompleted() {
      if (table.getSelectionIndex() < 0) {
         setErrorMessage(Messages.SearchGameByDateWizardPageOne_MissingGameSelectionError);
         setPageComplete(false);
         return;
      }

      setErrorMessage(null);
      setPageComplete(true);
   }

   /**
    * Update table display
    */
   private void updateTable() {
      Date startDate = getDate(startDatePicker, false);
      Date endDate = (btnRangeSelection.getSelection() ? getDate(endDatePicker, true) : startDate);

      LocalDate min = toLocalDate(startDate);
      LocalDate max = toLocalDate(endDate);

      table.removeAll();

      List<Date> dates = new ArrayList<>(gamesByDate.keySet());
      Collections.sort(dates);

      for (Date date : dates) {
         LocalDate currentDate = toLocalDate(date);

         if ((!currentDate.isBefore(min)) && (!currentDate.isAfter(max))) {

            List<Game> gamesForDate = gamesByDate.get(date);
            for (Game game : gamesForDate) {

               String hometeamName = game.getHometeam().getName();
               String visitorName = game.getVisitor().getName();
               String formattedDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
                     .format(DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM).withLocale(Locale.getDefault()));

               TableItem item = new TableItem(table, SWT.NONE);
               item.setData(game);
               item.setText(new String[] { formattedDate, game.getName(), hometeamName + " vs " + visitorName }); //$NON-NLS-1$
            }
         }
      }
      checkPageCompleted();
   }

   /**
    * Convert a date to a local date.
    * 
    * @param date date to convert
    * @return converted date
    */
   private LocalDate toLocalDate(Date date) {
      return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
   }

   /**
    * Get selected date.
    * 
    * @param datePicker    reference to the date picker widget
    * @param untilEndOfDay Flag for taking into accoutn the current day
    * 
    * @return data value
    */
   private Date getDate(DateTime datePicker, boolean untilEndOfDay) {
      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.YEAR, datePicker.getYear());
      cal.set(Calendar.MONTH, datePicker.getMonth());
      cal.set(Calendar.DAY_OF_MONTH, datePicker.getDay());

      if (untilEndOfDay) {
         cal.set(Calendar.HOUR_OF_DAY, 23);
         cal.set(Calendar.MINUTE, 59);
         cal.set(Calendar.SECOND, 59);
      }

      return cal.getTime();
   }

   /**
    * Initialisation of the limits
    */
   private void initDateLimits() {
      List<Date> dates = new ArrayList<>(gamesByDate.keySet());
      Collections.sort(dates);
      int endPosition = dates.size() - 1;

      Date startDate = dates.get(0);
      Date endDate = dates.get(endPosition);

      Calendar startCalendar = Calendar.getInstance();
      startCalendar.setTime(startDate);

      Calendar endCalendar = Calendar.getInstance();
      endCalendar.setTime(endDate);

      startDatePicker.setDate(startCalendar.get(Calendar.YEAR), startCalendar.get(Calendar.MONTH), startCalendar.get(Calendar.DAY_OF_MONTH));
      startDatePicker.setTime(0, 0, 0);
      endDatePicker.setDate(endCalendar.get(Calendar.YEAR), endCalendar.get(Calendar.MONTH), endCalendar.get(Calendar.DAY_OF_MONTH));
      endDatePicker.setTime(23, 59, 59);
   }

   /**
    * Get the selected game.
    * 
    * @return Selected game
    */
   public Game getSelectedGame() {
      int selectedIndex = table.getSelectionIndex();
      if (selectedIndex >= 0) {
         return (Game) table.getItem(selectedIndex).getData();
      }
      return null;
   }
}
