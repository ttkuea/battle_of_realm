package constants;

import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.image.*;

public class Images{
	public static final Image Logo = new Image(ClassLoader.getSystemResource("Images/Logo.png").toString(),50,50,true,false);
	public static final Image startBG = new Image(ClassLoader.getSystemResource("Images/Start_BG.png").toString(),1024,768,true,false);
	public static final Image startButton = new Image(ClassLoader.getSystemResource("Images/Start_Button.png").toString(),200,60,true,false);
	public static final Image quitButton = new Image(ClassLoader.getSystemResource("Images/Quit_Button.png").toString(),200,60,true,false);
	
	public static final Image gameOver = new Image(ClassLoader.getSystemResource("Images/Game_Over.png").toString(),1024,768,true,false);
	public static final Image victory = new Image(ClassLoader.getSystemResource("Images/Victory_Scene.png").toString(),1024,768,true,false);
	
	public static final Image cursor = new Image(ClassLoader.getSystemResource("Images/Cursor.png").toString(),50,50,true,false);
	public static final Image nextButton = new Image(ClassLoader.getSystemResource("Images/nextButton.png").toString());
	public static final Image nextButtonHover = new Image(ClassLoader.getSystemResource("Images/Initial_Next_Button.png").toString());
	
	public static final Image titleLogo = new Image(ClassLoader.getSystemResource("Images/Title.png").toString(),600,375,true,false);
	
	public static final Image[] worldMaps = {new Image(ClassLoader.getSystemResource("Images/Map_1.png").toString(),1024,768,true,false),
											 new Image(ClassLoader.getSystemResource("Images/Map_2.png").toString(),1024,768,true,false),
											 new Image(ClassLoader.getSystemResource("Images/Map_3.png").toString(),1024,768,true,false),
											 new Image(ClassLoader.getSystemResource("Images/Map_4.png").toString(),1024,768,true,false),
											 new Image(ClassLoader.getSystemResource("Images/Map_5.png").toString(),1024,768,true,false),
											 new Image(ClassLoader.getSystemResource("Images/Map_6.png").toString(),1024,768,true,false)};
	
	public static final Image stage1BG = new Image(ClassLoader.getSystemResource("Images/Stage1.jpg").toString(),1024,768,true,false);
	public static final Image stage2BG = new Image(ClassLoader.getSystemResource("Images/Stage2.jpg").toString(),1024,768,true,false);
	public static final Image stage3BG = new Image(ClassLoader.getSystemResource("Images/Stage3.png").toString(),1024,768,true,false);
	public static final Image stage4BG = new Image(ClassLoader.getSystemResource("Images/Stage4.jpg").toString(),1024,768,true,false);
	public static final Image stage5BG = new Image(ClassLoader.getSystemResource("Images/Stage5.jpg").toString(),1024,768,true,false);
	public static final Image bossBG = new Image(ClassLoader.getSystemResource("Images/BossMap.jpg").toString(),1024,768,true,false);
	
	//Warrior
	public static final Image warriorIdle1 = new Image(ClassLoader.getSystemResource("Images/warrior_1_45.png").toString(),150,150,true,false);
	public static final Image warriorIdle2 = new Image(ClassLoader.getSystemResource("Images/warrior_2_45.png").toString(),150,150,true,false);
	public static final Image warriorIdle3 = new Image(ClassLoader.getSystemResource("Images/warrior_3_45.png").toString(),150,150,true,false);
	public static final Image warriorAtk1 = new Image(ClassLoader.getSystemResource("Images/Warrior_Atk_1_45.png").toString(),100,100,true,false);
	public static final Image warriorAtk2 = new Image(ClassLoader.getSystemResource("Images/Warrior_Atk_2_45.png").toString(),100,100,true,false);
	public static final Image warriorSkill1 = new Image(ClassLoader.getSystemResource("Images/Warrior_Skill_Move_1.png").toString(),100,100,true,false);
	public static final Image warriorSkill2 = new Image(ClassLoader.getSystemResource("Images/Warrior_Skill_Move_2.png").toString(),100,100,true,false);
	public static final Image warriorSkill3 = new Image(ClassLoader.getSystemResource("Images/Warrior_Skill_Move_3.png").toString(),100,100,true,false);
	public static final Image warriorSkill4 = new Image(ClassLoader.getSystemResource("Images/Warrior_Skill_Move_4.png").toString(),100,100,true,false);
	public static final Image warriorSkill5 = new Image(ClassLoader.getSystemResource("Images/Warrior_Skill_Move_5.png").toString(),100,100,true,false);
	public static final Image warriorUlti = new Image(ClassLoader.getSystemResource("Images/Warrior_Ulti_Move.png").toString(),100,100,true,false);
	
	//Wizard
	public static final Image wizardIdle1 = new Image(ClassLoader.getSystemResource("Images/wizard_1_45.png").toString(),100,100,true,false);
	public static final Image wizardIdle2 = new Image(ClassLoader.getSystemResource("Images/wizard_2_45.png").toString(),100,100,true,false);
	public static final Image wizardIdle3 = new Image(ClassLoader.getSystemResource("Images/wizard_3_45.png").toString(),100,100,true,false);
	public static final Image wizardAtk1 = new Image(ClassLoader.getSystemResource("Images/Wizard_Atk_1_45.png").toString(),100,100,true,false);
	public static final Image wizardAtk2 = new Image(ClassLoader.getSystemResource("Images/Wizard_Atk_2_48.png").toString(),100,100,true,false);
	
	//Archer
	public static final Image archerIdle1 = new Image(ClassLoader.getSystemResource("Images/archer_1_36.png").toString(),100,100,true,false);
	public static final Image archerIdle2 = new Image(ClassLoader.getSystemResource("Images/archer_2_36.png").toString(),100,100,true,false);
	public static final Image archerIdle3 = new Image(ClassLoader.getSystemResource("Images/archer_3_36.png").toString(),100,100,true,false);
	public static final Image archerAtk1 = new Image(ClassLoader.getSystemResource("Images/Archer_Atk_1_36.png").toString(),100,100,true,false);
	public static final Image archerAtk2 = new Image(ClassLoader.getSystemResource("Images/Archer_Atk_2_42.png").toString(),100,100,true,false);
	public static final Image archerAtk3 = new Image(ClassLoader.getSystemResource("Images/Archer_Atk_3_42.png").toString(),100,100,true,false);
	public static final Image archerSkill = new Image(ClassLoader.getSystemResource("Images/Archer_Skill_Move.png").toString(),100,100,true,false);
	public static final Image archerUlti1 = new Image(ClassLoader.getSystemResource("Images/Archer_Ulti_Move_1.png").toString(),100,100,true,false);
	public static final Image archerUlti2 = new Image(ClassLoader.getSystemResource("Images/Archer_Ulti_Move_2.png").toString(),100,100,true,false);
	public static final Image archerUlti3 = new Image(ClassLoader.getSystemResource("Images/Archer_Ulti_Move_3.png").toString(),100,100,true,false);
	public static final Image archerUlti4 = new Image(ClassLoader.getSystemResource("Images/Archer_Ulti_Move_4.png").toString(),100,100,true,false);
	
	
	//SKILL LIST
	public static final Image archerNormalIcon = new Image(ClassLoader.getSystemResource("Images/Archer_Normal_Icon.png").toString(),70,70,true,false);
	public static final Image archerSkillIcon = new Image(ClassLoader.getSystemResource("Images/Archer_Skill_Icon.png").toString(),70,70,true,false);
	public static final Image archerUltiIcon = new Image(ClassLoader.getSystemResource("Images/Archer_Ulti_Icon.png").toString(),70,70,true,false);
	public static final Image archerNormalCD = new Image(ClassLoader.getSystemResource("Images/Archer_Normal_CD.png").toString(),70,70,true,false);
	public static final Image archerSkillCD = new Image(ClassLoader.getSystemResource("Images/Archer_Skill_CD.png").toString(),70,70,true,false);
	public static final Image archerUltiCD = new Image(ClassLoader.getSystemResource("Images/Archer_Ulti_CD.png").toString(),70,70,true,false);
	
	
	public static final Image warriorNormalIcon = new Image(ClassLoader.getSystemResource("Images/Warrior_Normal_Icon.png").toString(),70,70,true,false);
	public static final Image warriorSkillIcon = new Image(ClassLoader.getSystemResource("Images/Warrior_Skill_Icon.png").toString(),70,70,true,false);
	public static final Image warriorUltiIcon = new Image(ClassLoader.getSystemResource("Images/Warrior_Ulti_Icon.png").toString(),70,70,true,false);
	public static final Image warriorNormalCD = new Image(ClassLoader.getSystemResource("Images/Warrior_Normal_CD.png").toString(),70,70,true,false);
	public static final Image warriorSkillCD = new Image(ClassLoader.getSystemResource("Images/Warrior_Skill_CD.png").toString(),70,70,true,false);
	public static final Image warriorUltiCD = new Image(ClassLoader.getSystemResource("Images/Warrior_Ulti_CD.png").toString(),70,70,true,false);
	
	public static final Image wizardSkill1Icon = new Image(ClassLoader.getSystemResource("Images/Wizard_Skill1_Icon.png").toString(),70,70,true,false);
	public static final Image wizardSkill2Icon = new Image(ClassLoader.getSystemResource("Images/Wizard_Skill2_Icon.png").toString(),70,70,true,false);
	public static final Image wizardHealIcon = new Image(ClassLoader.getSystemResource("Images/Wizard_Heal_Icon.png").toString(),70,70,true,false);
	public static final Image wizardSkill1CD = new Image(ClassLoader.getSystemResource("Images/Wizard_Skill1_CD.png").toString(),70,70,true,false);
	public static final Image wizardSkill2CD = new Image(ClassLoader.getSystemResource("Images/Wizard_Skill2_CD.png").toString(),70,70,true,false);
	public static final Image wizardHealCD = new Image(ClassLoader.getSystemResource("Images/Wizard_Heal_CD.png").toString(),70,70,true,false);
	
	//ENEMY
	public static final Image lavaIdle1 = new Image(ClassLoader.getSystemResource("Images_Enemy/Lava_1_54.png").toString(),100,100,true,false);
	public static final Image lavaIdle2 = new Image(ClassLoader.getSystemResource("Images_Enemy/Lava_2_54.png").toString(),100,100,true,false);
	public static final Image lavaAtk1 = new Image(ClassLoader.getSystemResource("Images_Enemy/Lava__Atk_1_54.png").toString(),100,100,true,false);
	public static final Image lavaAtk2 = new Image(ClassLoader.getSystemResource("Images_Enemy/Lava__Atk_2_54.png").toString(),100,100,true,false);
	public static final Image lavaAtk3 = new Image(ClassLoader.getSystemResource("Images_Enemy/Lava__Atk_3_54.png").toString(),100,100,true,false);
	
	public static final Image griffinIdle1 = new Image(ClassLoader.getSystemResource("Images_Enemy/Griffin_1_120.png").toString(),100,100,true,false);
	public static final Image griffinIdle2 = new Image(ClassLoader.getSystemResource("Images_Enemy/Griffin_2_105.png").toString(),100,100,true,false);
	public static final Image griffinAtk1 = new Image(ClassLoader.getSystemResource("Images_Enemy/Griffin_Atk_1_90.png").toString(),100,100,true,false);
	public static final Image griffinAtk2 = new Image(ClassLoader.getSystemResource("Images_Enemy/Griffin_Atk_2_120.png").toString(),100,100,true,false);
	
	public static final Image badWizardIdle1 = new Image(ClassLoader.getSystemResource("Images_Enemy/badWizard_1_78.png").toString(),100,100,true,false);
	public static final Image badWizardIdle2 = new Image(ClassLoader.getSystemResource("Images_Enemy/badWizard_2_78.png").toString(),100,100,true,false);
	public static final Image badWizardIdle3 = new Image(ClassLoader.getSystemResource("Images_Enemy/badWizard_3_78.png").toString(),100,100,true,false);
	public static final Image badWizardAtk1 = new Image(ClassLoader.getSystemResource("Images_Enemy/badWizard__Atk_1_81.png").toString(),100,100,true,false);
	public static final Image badWizardAtk2 = new Image(ClassLoader.getSystemResource("Images_Enemy/badWizard__Atk_2_81.png").toString(),100,100,true,false);
	
	public static final Image dragonIdle1 = new Image(ClassLoader.getSystemResource("Images_Enemy/blackDragon_1_195.png").toString(),200,200,true,false);
	public static final Image dragonIdle2 = new Image(ClassLoader.getSystemResource("Images_Enemy/blackDragon_2_195.png").toString(),200,200,true,false);
	public static final Image dragonAtk1 = new Image(ClassLoader.getSystemResource("Images_Enemy/blackDragon_Atk_1_120.png").toString(),200,200,true,false);
	public static final Image dragonAtk2 = new Image(ClassLoader.getSystemResource("Images_Enemy/blackDragon_Atk_2_135.png").toString(),200,200,true,false);
	
	public static final Image bossIdle1 = new Image(ClassLoader.getSystemResource("Images_Enemy/Boss_1_90.png").toString(),100,100,true,false);
	public static final Image bossIdle2 = new Image(ClassLoader.getSystemResource("Images_Enemy/Boss_2_90.png").toString(),100,100,true,false);
	public static final Image bossIdle3 = new Image(ClassLoader.getSystemResource("Images_Enemy/Boss_3_90.png").toString(),100,100,true,false);
	
	public static final Image bossAtk1 = new Image(ClassLoader.getSystemResource("Images_Enemy/Boss_Atk_1_90.png").toString(),100,100,true,false);
	public static final Image bossAtk2 = new Image(ClassLoader.getSystemResource("Images_Enemy/Boss_Atk_2_90.png").toString(),100,100,true,false);
	public static final Image bossAtk3 = new Image(ClassLoader.getSystemResource("Images_Enemy/Boss_Atk_3_90.png").toString(),100,100,true,false);
	
	public static final ArrayList<Image> lavaIdles = new ArrayList<>();
	public static final ArrayList<Image> lavaAtks = new ArrayList<>();
	public static final ArrayList<Image> griffinIdles = new ArrayList<>();
	public static final ArrayList<Image> griffinAtks = new ArrayList<>();
	public static final ArrayList<Image> badWizardIdles = new ArrayList<>();
	public static final ArrayList<Image> badWizardAtks = new ArrayList<>();
	public static final ArrayList<Image> dragonIdles = new ArrayList<>();
	public static final ArrayList<Image> dragonAtks = new ArrayList<>();
	public static final ArrayList<Image> bossIdles = new ArrayList<>();
	public static final ArrayList<Image> bossAtks = new ArrayList<>();
	
	//Particles
	public static final Image normalParticle = new Image(ClassLoader.getSystemResource("Images_Particle/Normal_Hit.png").toString(),100,100,true,false);
	public static final Image ultiParticle = new Image(ClassLoader.getSystemResource("Images_Particle/Ulti_Hit.png").toString(),100,100,true,false);
	public static final Image wizard1Particle = new Image(ClassLoader.getSystemResource("Images_Particle/Wizard_Skill_1.png").toString(),100,100,true,false);
	public static final Image wizard2Particle = new Image(ClassLoader.getSystemResource("Images_Particle/Wizard_Skill_2.png").toString(),100,100,true,false);
	public static final Image wizardHealParticle = new Image(ClassLoader.getSystemResource("Images_Particle/Wizard_Heal.png").toString(),100,100,true,false);
	
	public static void loadImages() {
		Collections.addAll(lavaIdles, lavaIdle1, lavaIdle2);
		Collections.addAll(lavaAtks, lavaAtk1, lavaAtk2, lavaAtk3);
		Collections.addAll(griffinIdles, griffinIdle1, griffinIdle2);
		Collections.addAll(griffinAtks, griffinAtk1, griffinAtk2);
		Collections.addAll(badWizardIdles, badWizardIdle1, badWizardIdle2, badWizardIdle3);
		Collections.addAll(badWizardAtks, badWizardAtk1, badWizardAtk2);
		Collections.addAll(dragonIdles, dragonIdle1, dragonIdle2);
		Collections.addAll(dragonAtks, dragonAtk1, dragonAtk2);
		Collections.addAll(bossIdles, bossIdle1, bossIdle2, bossIdle3);
		Collections.addAll(bossAtks, bossAtk1, bossAtk2, bossAtk3);
	}
	
}
