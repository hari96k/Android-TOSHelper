package hari.tosHelper;

import android.widget.EditText;

import java.util.HashMap;

public class mainPage {
    static final HashMap<String, Integer> alignmentBackground = new HashMap<String, Integer>() {
        {
            put("Town Investigative", R.color.town);
            put("Town Support", R.color.town);
            put("Town Protective", R.color.town);
            put("Town Killing", R.color.town);
            put("Random Town", R.color.town);
            put("Mafia Killing", R.color.mafia);
            put("Random Mafia", R.color.mafia);
            put("Mafia Support", R.color.mafia);
            put("Mafia Deception", R.color.mafia);
            put("Neutral Killing", R.color.neutral);
            put("Neutral Evil", R.color.neutral);
            put("Neutral Benign", R.color.neutral);
            put("Any", R.color.white);
            put("Neutral Chaos", R.color.neutral);
            put("Random Neutral", R.color.neutral);
            put("Coven Evil", R.color.coven);
            put("Random Coven", R.color.coven);
        }
    };
    static final HashMap<String, Integer> alignmentColors = new HashMap<String, Integer>() {
        {
            put("Town Investigative", R.color.townText);
            put("Town Support", R.color.townText);
            put("Town Protective", R.color.townText);
            put("Town Killing", R.color.townText);
            put("Random Town", R.color.townText);
            put("Mafia Killing", R.color.mafiaText);
            put("Random Mafia", R.color.mafiaText);
            put("Mafia Support", R.color.mafiaText);
            put("Mafia Deception", R.color.mafiaText);

            put("Coven Evil", R.color.covenText);
            put("Random Coven", R.color.covenText);

            put("Neutral Killing", R.color.exeText);
            put("Neutral Evil", R.color.exeText);
            put("Neutral Benign", R.color.exeText);
            put("Any", R.color.black);
            put("Neutral Chaos", R.color.exeText);
            put("Random Neutral", R.color.exeText);
        }
    };
    static final HashMap<String, Integer> roleBackground = new HashMap<String, Integer>() {
        {
            put("Jailor", R.color.town);
            put("Investigator", R.color.town);
            put("Lookout", R.color.town);
            put("Sheriff", R.color.town);
            put("Spy", R.color.town);
            put("Escort", R.color.town);
            put("Mayor", R.color.town);
            put("Medium", R.color.town);
            put("Retributionist", R.color.town);
            put("Transporter", R.color.town);
            put("Bodyguard", R.color.town);
            put("Doctor", R.color.town);
            put("Vampire Hunter", R.color.town);
            put("Veteran", R.color.town);
            put("Vigilante", R.color.town);
            put("Godfather", R.color.mafia);
            put("Mafioso", R.color.mafia);
            put("Blackmailer", R.color.mafia);
            put("Consigliere", R.color.mafia);
            put("Consort", R.color.mafia);
            put("Disguiser", R.color.mafia);
            put("Forger", R.color.mafia);
            put("Framer", R.color.mafia);
            put("Janitor", R.color.mafia);
            put("Arsonist", R.color.neutral);
            put("Serial Killer", R.color.neutral);
            put("Werewolf", R.color.neutral);
            put("Executioner", R.color.neutral);
            put("Jester", R.color.neutral);
            put("Witch", R.color.neutral);
            put("Amnesiac", R.color.neutral);
            put("Survivor", R.color.neutral);
            put("Vampire", R.color.neutral);

            put("Coven Leader", R.color.coven);
            put("Hex Master", R.color.coven);
            put("Poisoner", R.color.coven);
            put("Potion Master", R.color.coven);
            put("Medusa", R.color.coven);
            put("Necromancer", R.color.coven);
            put("Ambusher", R.color.mafia);
            put("Hypnotist", R.color.mafia);
            put("Guardian Angel", R.color.neutral);
            put("Pirate", R.color.neutral);
            put("Psychic", R.color.town);
            put("Crusader", R.color.town);
            put("Tracker", R.color.town);
            put("Trapper", R.color.town);
            put("Plaguebearer", R.color.neutral);
            put("Pestilence", R.color.neutral);
            put("Juggernaut", R.color.neutral);
        }
    };
    static final HashMap<String, Integer> roleColors = new HashMap<String, Integer>() {
        {
            put("Jailor", R.color.townText);
            put("Investigator", R.color.townText);
            put("Lookout", R.color.townText);
            put("Sheriff", R.color.townText);
            put("Spy", R.color.townText);
            put("Escort", R.color.townText);
            put("Mayor", R.color.townText);
            put("Medium", R.color.townText);
            put("Retributionist", R.color.townText);
            put("Transporter", R.color.townText);
            put("Bodyguard", R.color.townText);
            put("Doctor", R.color.townText);
            put("Vampire Hunter", R.color.townText);
            put("Veteran", R.color.townText);
            put("Vigilante", R.color.townText);

            put("Psychic", R.color.townText);
            put("Tracker", R.color.townText);
            put("Crusader", R.color.townText);
            put("Trapper", R.color.townText);

            put("Godfather", R.color.mafiaText);
            put("Mafioso", R.color.mafiaText);
            put("Mafia", R.color.mafiaText);
            put("Blackmailer", R.color.mafiaText);
            put("Consigliere", R.color.mafiaText);
            put("Consort", R.color.mafiaText);
            put("Disguiser", R.color.mafiaText);
            put("Forger", R.color.mafiaText);
            put("Framer", R.color.mafiaText);
            put("Janitor", R.color.mafiaText);

            put("Coven Leader", R.color.covenText);
            put("Hex Master", R.color.covenText);
            put("Poisoner", R.color.covenText);
            put("Potion Master", R.color.covenText);
            put("Medusa", R.color.covenText);
            put("Necromancer", R.color.covenText);
            put("Arsonist", R.color.arsonistText);
            put("Serial Killer", R.color.skText);
            put("Werewolf", R.color.wwText);
            put("Executioner", R.color.exeText);
            put("Jester", R.color.jesterText);
            put("Witch", R.color.witchText);
            put("Amnesiac", R.color.amneText);
            put("Survivor", R.color.survivorText);
            put("Vampire", R.color.exeText);

            put("Ambusher", R.color.mafiaText);
            put("Hypnotist", R.color.mafiaText);
            put("Guardian Angel", R.color.white);
            put("Pirate", R.color.pirateText);
            put("Crusader", R.color.townText);
            put("Tracker", R.color.townText);
            put("Trapper", R.color.townText);
            put("Plaguebearer", R.color.plaguebearerText);
            put("Pestilence", R.color.pestilenceText);
            put("Juggernaut", R.color.juggernautText);
        }
    };
    static int standardHeight;
    static int standardTitleHeight;

    static String decodeRole(String role) {
        switch (role) {
            case "Vamp Hunter" /*0*/:
                return "Vampire Hunter";
            default:
                return role;
        }
    }

}
