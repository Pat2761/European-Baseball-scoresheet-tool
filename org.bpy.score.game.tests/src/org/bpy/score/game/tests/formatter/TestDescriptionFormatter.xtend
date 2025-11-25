package org.bpy.score.game.tests.formatter

import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.bpy.score.game.tests.GameInjectorProvider
import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.InjectWith
import com.google.inject.Inject
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.testing.util.ParseHelper
import org.bpy.score.game.game.Game
import org.junit.jupiter.api.Test
import java.nio.file.Files
import java.nio.file.Paths
import java.io.File

@ExtendWith(InjectionExtension)
@InjectWith(GameInjectorProvider)

class TestDescriptionFormatter {
	
	@Inject extension ParseHelper<Game>
	@Inject extension ISerializer
	
	private val File resourcesDirectory = new File("src/test/resources");
	
	@Test
	def void testFormatAllDescription() {
//		val input = "/org/bpy/score/game/tests/formatter/testFormatAllDescription.game".filaAsString
//		val expectedFormat = "/org/bpy/score/game/tests/formatter/testFormatAllDescription_expected.game".filaAsString

//		Assertions.assertEquals(expectedFormat, input.format)
	}

	
	def String getFilaAsString(String fileName) {
		val pathExpected = resourcesDirectory.getAbsolutePath() + fileName
		 Files.readString(Paths.get(pathExpected))
	}
	
}