package org.bpy.score.club.tests

import org.junit.jupiter.api.^extension.ExtendWith
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.junit.jupiter.api.Test
import com.google.inject.Inject
import org.eclipse.xtext.testing.util.ParseHelper
import org.bpy.score.club.club.Club
import org.junit.jupiter.api.Assertions
import org.eclipse.xtext.serializer.ISerializer
import org.eclipse.xtext.resource.SaveOptions

@ExtendWith(InjectionExtension)
@InjectWith(ClubInjectorProvider)

class FormatteValidation {
	
	@Inject extension ParseHelper<Club>
	@Inject extension ISerializer
	
	@Test
	def void MinimalFormatting() {
		val input = '''
		club "TestClub"{ city = "Somewhere";members {member name = "Player" licenceNumber = "00001";}}
		'''
		
		val expectedFormat  = '''
		club "TestClub" {
			city="Somewhere";
		
			members {
				member name="Player" licenceNumber="00001";
			}
		
		}
		'''
		
		Assertions.assertEquals(expectedFormat , input.parse.serialize(SaveOptions.newBuilder.format().getOptions()))
	}

	@Test
	def void MinimalFormattingWithShirtNumber() {
		val input = '''
		club "TestClub"    {    city    =  "Somewhere";members {member name = "Player" licenceNumber = "00001" shirtNumber    =   25   ; }}
		'''
		
		val expectedFormat  = '''
		club "TestClub" {
			city="Somewhere";
		
			members {
				member name="Player" licenceNumber="00001" shirtNumber=25;
			}
		
		}
		'''
		
		Assertions.assertEquals(expectedFormat , input.parse.serialize(SaveOptions.newBuilder.format().getOptions()))
	}

	@Test
	def void MinimalFormattingWithShortNameAndShirtNumber() {
		val input = '''
		club "TestClub"    {    city    =  "Somewhere";members {member name = "Player"    shortName  =  
		"Loulou" licenceNumber = "00001" shirtNumber    =   25   ; }}
		'''
		
		val expectedFormat  = '''
		club "TestClub" {
			city="Somewhere";
		
			members {
				member name="Player" shortName="Loulou" licenceNumber="00001" shirtNumber=25;
			}
		
		}
		'''
		
		Assertions.assertEquals(expectedFormat , input.parse.serialize(SaveOptions.newBuilder.format().getOptions()))
	}

	@Test
	def void MinimalFormattingWithCompletemember001() {
		val input = '''
		club "TestClub"    {    city    =  "Somewhere";members {member name = "Player"    shortName  =  
		"Loulou" licenceNumber = "00001" shirtNumber    =   25 		
		status = E ; }}
		'''
		
		val expectedFormat  = '''
		club "TestClub" {
			city="Somewhere";
		
			members {
				member name="Player" shortName="Loulou" licenceNumber="00001" shirtNumber=25 status=E;
			}
		
		}
		'''
		
		Assertions.assertEquals(expectedFormat , input.parse.serialize(SaveOptions.newBuilder.format().getOptions()))
	}

	@Test
	def void MinimalFormattingWithCompletemember002() {
		val input = '''
		club "TestClub"{ city = "Somewhere";members {member name = "Player" licenceNumber = "00001"
		 shirtNumber    =   25 /* state */  status= E ,UE,  Ex ,  
		 18U  ; }}'''
		
		val expectedFormat  = '''
		club "TestClub" {
			city="Somewhere";
		
			members {
				member name="Player" licenceNumber="00001" shirtNumber=25 /* state */ status= E,UE,Ex,18U;
			}
		
		}'''
		
		Assertions.assertEquals(expectedFormat , input.parse.serialize(SaveOptions.newBuilder.format().getOptions()))
	}
	
	@Test
	def void TestTeamDeclarationWithMultiplePlayers() {
		val input = '''
		club "TestClub" {
			city="Somewhere";
		
			members {
				member name="Player1" shortName="Loulou" licenceNumber="00001" shirtNumber=25 status= E;
				member name="Player2" shortName="Loulou" licenceNumber="00002" shirtNumber=25 status= E;
			}
			
		team"D1"    {  player name= "Player1"  ; 	player name ="Player2"   
			;	}
		
		}'''
		
		val expectedFormat  = '''
		club "TestClub" {
			city="Somewhere";
		
			members {
				member name="Player1" shortName="Loulou" licenceNumber="00001" shirtNumber=25 status=E;
				member name="Player2" shortName="Loulou" licenceNumber="00002" shirtNumber=25 status=E;
			}
		
			team "D1" {
				player name="Player1";
				player name="Player2";
			}
		
		}'''
		
		Assertions.assertEquals(expectedFormat , input.parse.serialize(SaveOptions.newBuilder.format().getOptions()))
	}

	@Test
	def void TestTeamDeclarationWithOnePlayer() {
		val input = '''
		club "TestClub" {
			city="Somewhere";
		
			members {
				member name="Player1" shortName="Loulou" licenceNumber="00001" shirtNumber=25 status= E;
				member name="Player2" shortName="Loulou" licenceNumber="00002" shirtNumber=25 status= E;
			}
			
		team"D1"    {  player name= "Player1"  	}
		
		}'''
		
		val expectedFormat  = '''
		club "TestClub" {
			city="Somewhere";
		
			members {
				member name="Player1" shortName="Loulou" licenceNumber="00001" shirtNumber=25 status=E;
				member name="Player2" shortName="Loulou" licenceNumber="00002" shirtNumber=25 status=E;
			}
		
			team "D1" {
				player name="Player1";
			}
		
		}'''
		
		Assertions.assertEquals(expectedFormat , input.parse.serialize(SaveOptions.newBuilder.format().getOptions()))
	}

	
	@Test
	def void checkOfficialsFormat() {
		val input = '''
		club "TestClub" {
			city="Somewhere";
		
			members {
				member name="Player1" shortName="Loulou" licenceNumber="00001" shirtNumber=25 status=E;
				member name="Player2" shortName="Loulou" licenceNumber="00002" shirtNumber=25 status=E;
			}
		
			team "D1" {
				player name="Player1";
				player name="Player2";
			}
		officials{ 
							umpire name   ="Player2"
							;
					
			}
		}'''
		
		val expectedFormat  = '''
		club "TestClub" {
			city="Somewhere";
		
			members {
				member name="Player1" shortName="Loulou" licenceNumber="00001" shirtNumber=25 status=E;
				member name="Player2" shortName="Loulou" licenceNumber="00002" shirtNumber=25 status=E;
			}
		
			team "D1" {
				player name="Player1";
				player name="Player2";
			}
		
			officials {
				umpire name="Player2";
			}
		}'''
		
		Assertions.assertEquals(expectedFormat , input.parse.serialize(SaveOptions.newBuilder.format().getOptions()))
	}
}