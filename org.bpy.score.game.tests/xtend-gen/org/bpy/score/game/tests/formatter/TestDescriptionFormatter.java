package org.bpy.score.game.tests.formatter;

import com.google.inject.Inject;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.bpy.score.game.game.Game;
import org.bpy.score.game.tests.GameInjectorProvider;
import org.eclipse.xtext.serializer.ISerializer;
import org.eclipse.xtext.testing.InjectWith;
import org.eclipse.xtext.testing.extensions.InjectionExtension;
import org.eclipse.xtext.testing.util.ParseHelper;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Extension;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(InjectionExtension.class)
@InjectWith(GameInjectorProvider.class)
@SuppressWarnings("all")
public class TestDescriptionFormatter {
  @Inject
  @Extension
  private ParseHelper<Game> _parseHelper;

  @Inject
  @Extension
  private ISerializer _iSerializer;

  private final File resourcesDirectory = new File("src/test/resources");

  @Test
  public void testFormatAllDescription() {
  }

  public String getFilaAsString(final String fileName) {
    try {
      String _xblockexpression = null;
      {
        String _absolutePath = this.resourcesDirectory.getAbsolutePath();
        final String pathExpected = (_absolutePath + fileName);
        _xblockexpression = Files.readString(Paths.get(pathExpected));
      }
      return _xblockexpression;
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
}
