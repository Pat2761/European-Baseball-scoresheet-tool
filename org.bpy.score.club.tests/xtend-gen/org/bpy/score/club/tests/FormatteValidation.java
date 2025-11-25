package org.bpy.score.club.tests;

import com.google.inject.Inject;
import org.bpy.score.club.club.Club;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.resource.SaveOptions;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(ClubInjectorProvider.class)
@SuppressWarnings("all")
public class FormatteValidation {
  @Inject
  @Extension
  private ParseHelper<Club> _parseHelper;

  @Inject
  @Extension
  private ISerializer _iSerializer;

  @Test
  public void MinimalFormatting() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("club \"TestClub\"{ city = \"Somewhere\";members {member name = \"Player\" licenceNumber = \"00001\";}}");
      _builder.newLine();
      final String input = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("club \"TestClub\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("city=\"Somewhere\";");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("members {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("member name=\"Player\" licenceNumber=\"00001\";");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String expectedFormat = _builder_1.toString();
      Assertions.assertEquals(expectedFormat, this._iSerializer.serialize(this._parseHelper.parse(input), SaveOptions.newBuilder().format().getOptions()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void MinimalFormattingWithShirtNumber() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("club \"TestClub\"    {    city    =  \"Somewhere\";members {member name = \"Player\" licenceNumber = \"00001\" shirtNumber    =   25   ; }}");
      _builder.newLine();
      final String input = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("club \"TestClub\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("city=\"Somewhere\";");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("members {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("member name=\"Player\" licenceNumber=\"00001\" shirtNumber=25;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String expectedFormat = _builder_1.toString();
      Assertions.assertEquals(expectedFormat, this._iSerializer.serialize(this._parseHelper.parse(input), SaveOptions.newBuilder().format().getOptions()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void MinimalFormattingWithShortNameAndShirtNumber() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("club \"TestClub\"    {    city    =  \"Somewhere\";members {member name = \"Player\"    shortName  =  ");
      _builder.newLine();
      _builder.append("\"Loulou\" licenceNumber = \"00001\" shirtNumber    =   25   ; }}");
      _builder.newLine();
      final String input = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("club \"TestClub\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("city=\"Somewhere\";");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("members {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("member name=\"Player\" shortName=\"Loulou\" licenceNumber=\"00001\" shirtNumber=25;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String expectedFormat = _builder_1.toString();
      Assertions.assertEquals(expectedFormat, this._iSerializer.serialize(this._parseHelper.parse(input), SaveOptions.newBuilder().format().getOptions()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void MinimalFormattingWithCompletemember001() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("club \"TestClub\"    {    city    =  \"Somewhere\";members {member name = \"Player\"    shortName  =  ");
      _builder.newLine();
      _builder.append("\"Loulou\" licenceNumber = \"00001\" shirtNumber    =   25 \t\t");
      _builder.newLine();
      _builder.append("status = E ; }}");
      _builder.newLine();
      final String input = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("club \"TestClub\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("city=\"Somewhere\";");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("members {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("member name=\"Player\" shortName=\"Loulou\" licenceNumber=\"00001\" shirtNumber=25 status=E;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      _builder_1.newLine();
      final String expectedFormat = _builder_1.toString();
      Assertions.assertEquals(expectedFormat, this._iSerializer.serialize(this._parseHelper.parse(input), SaveOptions.newBuilder().format().getOptions()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void MinimalFormattingWithCompletemember002() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("club \"TestClub\"{ city = \"Somewhere\";members {member name = \"Player\" licenceNumber = \"00001\"");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("shirtNumber    =   25 /* state */  status= E ,UE,  Ex ,  ");
      _builder.newLine();
      _builder.append(" ");
      _builder.append("18U  ; }}");
      final String input = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("club \"TestClub\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("city=\"Somewhere\";");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("members {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("member name=\"Player\" licenceNumber=\"00001\" shirtNumber=25 /* state */ status= E,UE,Ex,18U;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      final String expectedFormat = _builder_1.toString();
      Assertions.assertEquals(expectedFormat, this._iSerializer.serialize(this._parseHelper.parse(input), SaveOptions.newBuilder().format().getOptions()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void TestTeamDeclarationWithMultiplePlayers() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("club \"TestClub\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("city=\"Somewhere\";");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("members {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("member name=\"Player1\" shortName=\"Loulou\" licenceNumber=\"00001\" shirtNumber=25 status= E;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("member name=\"Player2\" shortName=\"Loulou\" licenceNumber=\"00002\" shirtNumber=25 status= E;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("team\"D1\"    {  player name= \"Player1\"  ; \tplayer name =\"Player2\"   ");
      _builder.newLine();
      _builder.append("\t");
      _builder.append(";\t}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      final String input = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("club \"TestClub\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("city=\"Somewhere\";");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("members {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("member name=\"Player1\" shortName=\"Loulou\" licenceNumber=\"00001\" shirtNumber=25 status=E;");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("member name=\"Player2\" shortName=\"Loulou\" licenceNumber=\"00002\" shirtNumber=25 status=E;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("team \"D1\" {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("player name=\"Player1\";");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("player name=\"Player2\";");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      final String expectedFormat = _builder_1.toString();
      Assertions.assertEquals(expectedFormat, this._iSerializer.serialize(this._parseHelper.parse(input), SaveOptions.newBuilder().format().getOptions()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void TestTeamDeclarationWithOnePlayer() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("club \"TestClub\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("city=\"Somewhere\";");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("members {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("member name=\"Player1\" shortName=\"Loulou\" licenceNumber=\"00001\" shirtNumber=25 status= E;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("member name=\"Player2\" shortName=\"Loulou\" licenceNumber=\"00002\" shirtNumber=25 status= E;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("\t");
      _builder.newLine();
      _builder.append("team\"D1\"    {  player name= \"Player1\"  \t}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("}");
      final String input = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("club \"TestClub\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("city=\"Somewhere\";");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("members {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("member name=\"Player1\" shortName=\"Loulou\" licenceNumber=\"00001\" shirtNumber=25 status=E;");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("member name=\"Player2\" shortName=\"Loulou\" licenceNumber=\"00002\" shirtNumber=25 status=E;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("team \"D1\" {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("player name=\"Player1\";");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("}");
      final String expectedFormat = _builder_1.toString();
      Assertions.assertEquals(expectedFormat, this._iSerializer.serialize(this._parseHelper.parse(input), SaveOptions.newBuilder().format().getOptions()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }

  @Test
  public void checkOfficialsFormat() {
    try {
      StringConcatenation _builder = new StringConcatenation();
      _builder.append("club \"TestClub\" {");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("city=\"Somewhere\";");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("members {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("member name=\"Player1\" shortName=\"Loulou\" licenceNumber=\"00001\" shirtNumber=25 status=E;");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("member name=\"Player2\" shortName=\"Loulou\" licenceNumber=\"00002\" shirtNumber=25 status=E;");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.newLine();
      _builder.append("\t");
      _builder.append("team \"D1\" {");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("player name=\"Player1\";");
      _builder.newLine();
      _builder.append("\t\t");
      _builder.append("player name=\"Player2\";");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("officials{ ");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append("umpire name   =\"Player2\"");
      _builder.newLine();
      _builder.append("\t\t\t\t\t");
      _builder.append(";");
      _builder.newLine();
      _builder.append("\t\t\t");
      _builder.newLine();
      _builder.append("\t");
      _builder.append("}");
      _builder.newLine();
      _builder.append("}");
      final String input = _builder.toString();
      StringConcatenation _builder_1 = new StringConcatenation();
      _builder_1.append("club \"TestClub\" {");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("city=\"Somewhere\";");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("members {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("member name=\"Player1\" shortName=\"Loulou\" licenceNumber=\"00001\" shirtNumber=25 status=E;");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("member name=\"Player2\" shortName=\"Loulou\" licenceNumber=\"00002\" shirtNumber=25 status=E;");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("team \"D1\" {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("player name=\"Player1\";");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("player name=\"Player2\";");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("officials {");
      _builder_1.newLine();
      _builder_1.append("\t\t");
      _builder_1.append("umpire name=\"Player2\";");
      _builder_1.newLine();
      _builder_1.append("\t");
      _builder_1.append("}");
      _builder_1.newLine();
      _builder_1.append("}");
      final String expectedFormat = _builder_1.toString();
      Assertions.assertEquals(expectedFormat, this._iSerializer.serialize(this._parseHelper.parse(input), SaveOptions.newBuilder().format().getOptions()));
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
