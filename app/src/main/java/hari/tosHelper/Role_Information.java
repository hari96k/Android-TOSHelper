package hari.tosHelper;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;


public class Role_Information extends Activity {

    protected static final HashMap<String, String[]> infoData = new HashMap<String, String[]>() {
        {
            // String[0] = Role Alignment & uniqueness
            // String[1] = Summary
            // String[2] = Abilities
            // String[3] = Attributes
            // String[4] = Goal
            // String[5] = (Optional) Mechanics

            put("Jailor", new String[]{"(Town Killing)\n(Unique Role)",
                    "A prison guard who secretly detains suspects.",
                    "You may choose one person during the day to jail for the night.",
                    "You may anonymously talk with your prisoner." +
                            "You can choose to execute your prisoner." +
                            "The jailed target can't perform their night ability." +
                            "While jailed the prisoner is safe from all attacks.",
                    "Lynch every criminal and evildoer.",
                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target knows your darkest secrets. They could be the Spy, Blackmailer, or Jailor.\n\n" +
                            "Consigliere - \n" +
                            "Your target detains people at night. They must be a Jailor."});

            put("Investigator", new String[]{"(Town Investigative)", "A private eye who secretly gathers information.",
                    "Investigate one person each night for a clue to their role.",
                    "None.",
                    "Lynch every criminal and evildoer.",
                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target has sensitive information to reveal. They could be the Investigator, Consigliere, or Mayor.\n\n" +
                            "Consigliere - \n" +
                            "Your target gathers information about people. They must be an Investigator.",

                    "Escort, Transporter, or Consort - Your target is skilled at disrupting others.\n\n" +
                    "Investigator, Consigliere, or Mayor - Your target has sensitive information to reveal.\n\n" +
                    "Sheriff, Executioner or Werewolf - Your target is waiting for the perfect moment to strike.\n\n" +
                    "Vigilante, Mafioso or Veteran - Your target owns a gun.\n\n" +
                    "Lookout, Forger or Amnesiac - Your target sticks to the shadows.\n\n" +
                    "Spy, Blackmailer or Jailor - Your target knows your darkest secrets.\n\n" +
                    "Doctor, Disguiser or Serial Killer - Your target is covered in blood.\n\n" +
                    "Bodyguard, Godfather or Arsonist - Your target is not afraid to get their hands dirty.\n\n" +
                    "Medium, Janitor, or Retributionist - Your target works with dead bodies.\n\n" +
                    "Survivor, Vampire Hunter or Witch - Your target keeps to themselves.\n\n" +
                    "Framer, Vampire or Jester - Your target may not be what they seem. (Note: You will also receive this message if your target was framed)"});

            put("Lookout", new String[]{"(Town Investigative)","An eagle-eyed observer, stealthily camping outside houses to gain information.",
                    "Watch one person at night to see who visits them.",
                    "None.",
                    "Lynch every criminal and evildoer.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target sticks to the shadows. They could be the Lookout, Forger or Amnesiac.\n\n" +
                            "Consigliere - \n" +
                            "Your target watches who visits people at night. They must be a Lookout."});

            put("Sheriff", new String[]{"(Town Investigative)","The law enforcer of the town, forced into hiding from threat of murder.",
                    "Check one person each night for suspicious activity.",
                    "You will know if your target is a member of the Mafia, except for the Godfather." +
                            "You will know if your target is a Serial Killer.",
                    "Lynch every criminal and evildoer.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target is waiting for the perfect moment to strike. They could be the Sheriff, Executioner or Werewolf.\n\n" +
                            "Consigliere - \n" +
                            "Your target is a protector of the town. They must be a Sheriff.",


                    "Your target is not suspicious:\n" +
                    "All Townies\n" +
                    "Amnesiac, Survivor\n" +
                    "Executioner, Jester, Witch\n" +
                    "Vampire\n" +
                    "Godfather\n" +
                    "Arsonist\n" +
                    "Werewolf during odd-numbered nights\n\n" +
                    "Your target is a member of the Mafia:\n" +
                    "All Mafia except Godfather\n" +
                    "Anyone who was visited by a Framer\n\n" +
                    "Your target is a Serial Killer!:\n" +
                    "Serial Killer\n\n" +
                    "Your target is a Werewolf:\n" +
                    "Werewolf during Full Moon\n\n"});

            put("Spy", new String[]{"(Town Investigative)","A stealthy eavesdropper who listens in on secret conversations.",
                    "You can secretly listen to the Mafia at night.",
                    "You can hear private messages." +
                            "You will know who the Mafia visit at night.",
                    "Lynch every criminal and evildoer.",


                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target knows your darkest secrets. They could be the Spy, Blackmailer, or Jailor.\n\n" +
                            "Consigliere - \n" +
                            "Your target secretly listens in on private conversations. They must be a Spy."});

            put("Escort", new String[]{"(Town Support)","A beautiful woman skilled in distraction.",
                    "Distract someone each night.",
                    "Distraction blocks your target from using their role's night ability." +
                            "You are immune to roleblocks.",
                    "Lynch every criminal and evildoer.",


                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target is skilled at disrupting others. They could be an Escort, Transporter or Consort.\n\n" +
                            "Consigliere - \n" +
                            "Your target is a beautiful woman working for the town. She must be an Escort."});

            put("Mayor", new String[]{"(Town Support)\n(Unique Role)","The leader of the town.",
                    "You may reveal yourself as the Mayor of the Town.",
                    "Once you have revealed yourself as Mayor your vote counts as 3 votes." +
                            "You may not be healed once you have revealed yourself.",
                    "Lynch every criminal and evildoer.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target has sensitive information to reveal. They could be the Investigator, Consigliere, or Mayor.\n\n" +
                            "Consigliere - \n" +
                            "Your target is the leader of the town. They must be the Mayor."});

            put("Medium", new String[]{"(Town Support)","A secret psychic who talks with the dead.",
                    "When dead speak to a living person at night.",
                    "You will speak to the dead anonymously each night you are alive." +
                            "You may only speak to a living person once.",
                    "Lynch every criminal and evildoer.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target works with dead bodies. They could be the Medium, Janitor or Retributionist.\n\n" +
                            "Consigliere - \n" +
                            "Your target speaks with the dead. They must be a Medium."});

            put("Retributionist", new String[]{"(Town Support)\n(Unique Role)", "A powerful mystic who will give one person a second chance at life.",
                    "You may revive a dead Town member.",
                    "You may only resurrect one person.",
                    "Lynch every criminal and evildoer.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target works with dead bodies. They could be the Medium, Janitor or Retributionist.\n\n" +
                            "Consigliere - \n" +
                            "Your target is a Retributionist."});

            put("Transporter", new String[]{"(Town Support)","A man who transports people without asking any questions.",
                    "Choose two people to transport at night.",
                    "Transporting two people swaps all targets against them." +
                            "You may transport yourself." +
                            "Your targets will know they were transported.",
                    "Lynch every criminal and evildoer.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target is skilled at disrupting others. They could be an Escort, Transporter or Consort.\n\n" +
                            "Consigliere - \n" +
                            "Your target specializes in transportation, they must be a Transporter."});

            put("Bodyguard", new String[]{"(Town Protective)",
                    "An ex-soldier who secretly makes a living by selling protection.",
                    "Protect one person from death at night.",
                    "If your target is attacked both you and your attacker will die instead." +
                            "Your counterattack ignores night immunity.",
                    "Lynch every criminal and evildoer.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target is not afraid to get their hands dirty. They could be the Bodyguard, Godfather or Arsonist.\n\n" +
                            "Consigliere - \n" +
                            "Your target is a trained protector, they must be a Bodyguard."});

            put("Doctor", new String[]{"(Town Protective)",
                    "A surgeon skilled in trauma care who secretly heals people.",
                    "Heal one person each night, preventing them from dying.",
                    "You may only heal yourself once." +
                            "You will know if your target is attacked.",
                    "Lynch every criminal and evildoer.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target is covered in blood. They could be the Doctor, Disguiser or Serial Killer.\n\n" +
                            "Consigliere - \n" +
                            "Your target is a professional surgeon, they must be a Doctor."});

            put("Vampire Hunter", new String[]{"(Town Killing)",
                    "A priest turned monster hunter, this person slays Vampires.",
                    "Check for Vampires each night.",
                    "If you find a Vampire you will stake them in the heart." +
                            "If a Vampire visits you they will be staked." +
                            "You can hear Vampires talk at night." +
                            "If you kill all Vampires you will become a Vigilante.",
                    "Lynch every criminal and evildoer.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target keeps to themselves. They could be a Survivor, Vampire Hunter or Witch.\n\n" +
                            "Consigliere - \n" +
                            "Your target tracks Vampires. They must be a Vampire Hunter!"});

            put("Veteran", new String[]{"(Town Killing)\n(Unique)",
                    "A paranoid war hero who will shoot anyone who visits him.",
                    "Decide if you will go on alert.",
                    "While on alert you can not be killed at night." +
                            "If anyone visits you while you are on alert they will be shot." +
                            "You can only go on alert 3 times." +
                            "You are immune to role blocks.",
                    "Lynch every criminal and evildoer.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target owns weapons. They could be a Vigilante, Veteran or Mafioso.\n\n" +
                            "Consigliere - \n" +
                            "Your target is a paranoid war hero. They must be a Veteran."});

            put("Vigilante", new String[]{"(Town Killing)",
                    "A corrupt cop who takes the law into his own hands.",
                    "Choose to take justice into your own hands and shoot someone.",
                    "If you shoot another Town member you will commit suicide over the guilt." +
                            "You can only shoot your gun 3 times.",
                    "Lynch every criminal and evildoer.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target owns weapons. They could be a Vigilante, Veteran or Mafioso.\n\n" +
                            "Consigliere - \n" +
                            "Your target will bend the law to enact justice. They must be a Vigilante."});

            put("Godfather", new String[]{"(Mafia Killing)\n(Unique Role)",
                    "The leader of organized crime.",
                    "Kill someone each night.",
                    "You can't be killed at night." +
                            "If there is a Mafioso he will attack the target instead of you." +
                            "You will appear to be a Town member to the Sheriff." +
                            "You can talk with the other Mafia at night.",
                    "Kill anyone that will not submit to the Mafia.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target is not afraid to get their hands dirty. They could be the Bodyguard, Godfather or Arsonist.\n\n" +
                            "Consigliere - \n" +
                            "Your target is the leader of the Mafia. They must be the Godfather."});

            put("Mafioso", new String[]{"(Mafia Killing)\n(Unique Role)",
                    "A member of organized crime, trying to work their way to the top.",
                    "Carry out the Godfather's orders.",
                    "You can kill if the Godfather doesn't give you orders." +
                            "If the Godfather dies you will become the next Godfather." +
                            "You can talk with the other Mafia at night.",
                    "Kill anyone that will not submit to the Mafia.",

                    "Sheriff -\nYour target is a member of the Mafia.\n\n" +
                            "Investigator -\n" +
                            "Your target owns weapons. They could be a Vigilante, Veteran or Mafioso.\n\n" +
                            "Consigliere - \n" +
                            "Your target does the Godfather's dirty work. They must be a Mafioso."});

            put("Blackmailer", new String[]{"(Mafia Support)",
                    "An eavesdropper who uses information to keep people quiet.",
                    "Prevents one person from speaking during the next day each night.",
                    "Blackmailed targets can not talk during the day." +
                            "If there are no kill capable Mafia roles left you will become a Mafioso." +
                            "You can talk with the other Mafia at night.",
                    "Kill anyone that will not submit to the Mafia.",

                    "Sheriff -\nYour target is a member of the Mafia.\n\n" +
                            "Investigator -\n" +
                            "Your target knows your darkest secrets. They could be the Spy, Blackmailer, or Jailor.\n\n" +
                            "Consigliere - \n" +
                            "Your target uses information to silence people. They must be a Blackmailer."});

            put("Consigliere", new String[]{"(Mafia Support)",
                    "A corrupted investigator who gathers information for the Mafia.",
                    "Check one person for their exact role each night.",
                    "If there are no kill capable Mafia roles left you will become a Mafioso." +
                            "You can talk with the other Mafia at night.",
                    "Kill anyone that will not submit to the Mafia.",

                    "Sheriff -\nYour target is a member of the Mafia.\n\n" +
                            "Investigator -\n" +
                            "Your target has sensitive information to reveal. They could be the Investigator, Consigliere, or Mayor.\n\n" +
                            "Consigliere - \n" +
                            "Your target gathers information for the Mafia. They must be a Consigliere."});

            put("Consort", new String[]{"(Mafia Support)",
                    "A beautiful dancer working for organized crime.",
                    "Distract someone each night.",
                    "Distraction blocks your target from using their role's night ability." +
                            "If there are no kill capable Mafia roles left you will become a Mafioso." +
                            "You can talk with the other Mafia at night.",
                    "Kill anyone that will not submit to the Mafia.",

                    "Sheriff -\nYour target is a member of the Mafia.\n\n" +
                            "Investigator -\n" +
                            "Your target is skilled at disrupting others. They could be an Escort, Transporter or Consort.\n\n" +
                            "Consigliere - \n" +
                            "Your target is a beautiful woman working for the Mafia. She must be a Consort."});

            put("Disguiser", new String[]{"(Mafia Deception)",
                    "A master of disguise who pretends to be other people.",
                    "Choose a target to disguise yourself as.",
                    "If your target dies you will appear to be them." +
                            "You can only use your night ability three times." +
                            "After disguising your name, position and character will be swapped with your targets.",
                    "Kill anyone that will not submit to the Mafia.",

                    "Sheriff -\nYour target is a member of the Mafia.\n\n" +
                            "Investigator -\n" +
                            "Your target is covered in blood. They could be the Doctor, Disguiser or Serial Killer.\n\n" +
                            "Consigliere - \n" +
                            "Your target pretends to be other people. They must be a Disguiser."});

            put("Forger", new String[]{"(Mafia Deception)",
                    "A crooked lawyer that replaces documents.",
                    "Choose a person and rewrite their last will at night.",
                    "If your target dies, their last will is replaced with your forgery." +
                            "You may only perform 3 forgeries.",
                    "Kill anyone that will not submit to the Mafia.",

                    "Sheriff -\nYour target is a member of the Mafia.\n\n" +
                            "Investigator -\n" +
                            "Your target sticks to the shadows. They could be the Lookout, Forger or Amnesiac.\n\n" +
                            "Consigliere - \n" +
                            "Your target forges documents. They must be a Framer or a Forger."});

            put("Framer", new String[]{"(Mafia Deception)",
                    "A skilled counterfeiter who manipulates information.",
                    "Choose someone to frame at night.",
                    "If your target is investigated they will appear to be a member of the Mafia." +
                            "If there are no kill capable Mafia roles left you will become a Mafioso.",
                    "Kill anyone that will not submit to the Mafia.",

                    "Sheriff -\nYour target is a member of the Mafia.\n\n" +
                            "Investigator -\n" +
                            "Your target may not be what they seem. They could be a Framer, Vampire, or Jester.\n\n" +
                            "Consigliere - \n" +
                            "Your target forges documents. They must be a Framer or a Forger."});

            put("Janitor", new String[]{"(Mafia Deception)",
                    "A sanitation expert working for organized crime.",
                    "Choose a person to clean at night.",
                    "If your target dies their role and last will won't be revealed to the Town." +
                            "Only you will see the cleaned targets role and last will." +
                            "You may only perform 3 cleanings.",
                    "Kill anyone that will not submit to the Mafia.",

                    "Sheriff -\nYour target is a member of the Mafia.\n\n" +
                            "Investigator -\n" +
                            "Your target works with dead bodies. They could be the Medium, Janitor or Retributionist.\n\n" +
                            "Consigliere - \n" +
                            "Your target cleans up dead bodies. They must be a Janitor."});

            put("Arsonist", new String[]{"(Neutral Killing)",
                    "A pyromaniac that wants to burn everyone.",
                    "Douse someone in gasoline or ignite all doused targets.",
                    "Targets will know that they are doused in gasoline." +
                            "Death from fire can't be prevented by healing or night immunities." +
                            "Select yourself to ignite doused people.",
                    "Live to see everyone burn.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target is not afraid to get their hands dirty. They could be the Bodyguard, Godfather or Arsonist.\n\n" +
                            "Consigliere - \n" +
                            "Your target likes to watch things burn. They must be an Arsonist."});

            put("Serial Killer", new String[]{"(Neutral Killing)",
                    "A psychotic criminal who wants everyone to die.",
                    "Kill someone each night.",
                    "If you are role blocked you will attack the role blocker instead of your target." +
                            "You can not be killed at night.",
                    "Kill everyone who would oppose you.",

                    "Sheriff -\nYour target is a Serial Killer!\n\n" +
                            "Investigator -\n" +
                            "Your target is covered in blood. They could be the Doctor, Disguiser or Serial Killer.\n\n" +
                            "Consigliere - \n" +
                            "Your target wants to kill everyone. They must be a Serial Killer."});

            put("Werewolf", new String[]{"(Neutral Killing)\n(Unique Role)",
                    "A beast that hides under the skin of a man.",
                    "Transform into a Werewolf during the full moon.",
                    "As a Werewolf you can not be killed at night." +
                            "As a Werewolf you will attack your victim and anyone that visits them." +
                            "Your attack goes through night immunity.",
                    "Kill everyone who would oppose you.",

                    "Sheriff -\nYour target is a Werewolf(Only during Full Moons).\n\n" +
                            "Investigator -\n" +
                            "Your target is waiting for the perfect moment to strike. They could be the Sheriff, Executioner or Werewolf.\n\n" +
                            "Consigliere - \n" +
                            "Your target howls at the moon. They must be a Werewolf."});

            put("Executioner", new String[]{"(Neutral Evil)",
                    "An obsessed lyncher who will stop at nothing to execute his target.",
                    "Trick the Town into lynching your target.",
                    "Your target is >Your target's name<" +
                            "If your target is killed at night you will become a Jester.",
                    "Get your target lynched at any cost.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target is waiting for the perfect moment to strike. They could be the Sheriff, Executioner or Werewolf.\n\n" +
                            "Consigliere - \n" +
                            "Your target wants someone to be lynched at any cost. They must be an Executioner."});

            put("Jester", new String[]{"(Neutral Evil)",
                    "A crazed lunatic whose life goal is to be publicly executed.",
                    "Trick the Town into voting against you.",
                    "If you are lynched you may kill one of your guilty voters the following night.",
                    "Get yourself lynched by any means necessary.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target may not be what they seem. They could be a Framer, Vampire, or Jester.\n\n" +
                            "Consigliere - \n" +
                            "Your target wants to be lynched. They must be a Jester."});

            put("Witch", new String[]{"(Neutral Evil)",
                    "A voodoo master who can control other people's actions.",
                    "Control someone each night.",
                    "You can only control targetable actions such as detection and killing." +
                            "You can force people to target themselves." +
                            "Your victim will know they are being controlled.",
                    "Survive to see the Town lose the game.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target keeps to themselves. They could be a Survivor, Vampire Hunter or Witch.\n\n" +
                            "Consigliere - \n" +
                            "Your target casts spells on people. They must be a Witch."});

            put("Amnesiac", new String[]{"(Neutral Benign)",
                    "A trauma patient that does not remember who he was.",
                    "Remember who you were by selecting a graveyard role.",
                    "When you choose a role it will be revealed to the Town." +
                            "You can't choose a unique role.",
                    "Remember who you were and complete that roles objectives.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target sticks to the shadows. They could be the Lookout, Forger or Amnesiac.\n\n" +
                            "Consigliere - \n" +
                            "Your target does not remember their role. They must be an Amnesiac."});

            put("Survivor", new String[]{"(Neutral Benign)",
                    "A neutral character who just wants to live.",
                    "Put on a bulletproof vest on at night, protecting you from attacks.",
                    "You can only use the bulletproof vest 4 times.",
                    "Live until the end of the game.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target keeps to themselves. They could be a Survivor, Vampire Hunter or Witch.\n\n" +
                            "Consigliere - \n" +
                            "Your target simply wants to live. They must be a Survivor."});

            put("Vampire", new String[]{"(Neutral Chaos)",
                    "A blood thirsty Vampire that bites and converts humans to Vampires at night.",
                    "Convert others to Vampires at night.",
                    "Vampires vote at night to bite a target." +
                            "The youngest Vampire will visit the target at night." +
                            "You must wait 1 night between conversions.",
                    "Convert everyone who would oppose you.",

                    "Sheriff -\nYour target is not suspicious.\n\n" +
                            "Investigator -\n" +
                            "Your target may not be what they seem. They could be a Framer, Vampire, or Jester.\n\n" +
                            "Consigliere - \n" +
                            "Your target drinks blood. They must be a Vampire!"});
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int position = getIntent().getIntExtra("position", 0);
        String role = getIntent().getStringExtra("selection");
        setContentView(R.layout.activity_roleinfo_page);
        setInfo(role, position);
    }

    private void setInfo(String role, int position) {
        TextView infoField = (TextView) findViewById(R.id.roleTitle);
        infoField.setText(role);
        infoField.setTextColor(ContextCompat.getColor(Role_Information.this, customAdapter.textColor[position]));

        infoField = (TextView) findViewById(R.id.roleAttribute);
        infoField.setText(infoData.get(role)[0]);

        infoField = (TextView) findViewById(R.id.summaryInfo);
        infoField.setText(infoData.get(role)[1]);

        infoField = (TextView) findViewById(R.id.abilitiesInfo);
        infoField.setText(infoData.get(role)[2]);

        infoField = (TextView) findViewById(R.id.attributesInfo);
        infoField.setText(infoData.get(role)[3]);

        infoField = (TextView) findViewById(R.id.goalInfo);
        infoField.setText(infoData.get(role)[4]);

        infoField = (TextView) findViewById(R.id.investResultsInfo);
        infoField.setText(infoData.get(role)[5]);

        if (infoData.get(role).length > 6) {
            infoField = (TextView) findViewById(R.id.mechanicsTitle);
            infoField.setVisibility(View.VISIBLE);
            infoField = (TextView) findViewById(R.id.mechanicsInfo);
            infoField.setVisibility(View.VISIBLE);
            infoField.setPadding(0, 10, 0, 10);
            infoField.setText(infoData.get(role)[6]);
        }
    }


}