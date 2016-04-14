package strategy.actStrategy;

import java.util.ArrayList;
import java.util.List;

import mapComponent.Case;
import model.GameModel;

import strategy.attackStrategy.AttackStrategy;
import strategy.moveStrategy.MoveStrategy;
import entities.Character;
import entities.Defence;
import entities.Entity;

public class AimNexusActStrategy implements ActStrategy<Character> {
	// ATTRIBUTES
	private AttackStrategy attackStrategy;
	private MoveStrategy moveStrategy;
	private Character character;

	// METHODS
	/**
	 * Constructor
	 * 
	 * @param att
	 *            attackstrategy to add
	 * @param move
	 *            movestrategy to add
	 * @param character
	 *            that gonna act the strategy
	 */
	public AimNexusActStrategy(AttackStrategy att, MoveStrategy move,
			Character character) {
		this.attackStrategy = att;
		this.moveStrategy = move;
		this.character = character;
	}

	@Override
	public void action() {
		List<Case> charactereCase = GameModel.map.getCasesOfEntity(character);
		List<Case> neighbors = new ArrayList<Case>();
		for (Case c : charactereCase)
			neighbors.addAll(GameModel.map.getNeighbors(c));
		if (neighbors.size() < 1)
			return;
		Case closestOfNexus = null;
		for (Case c : neighbors) {
			if (closestOfNexus == null) {
				if (c.getPathFindingNexus() != -1)
					closestOfNexus = c;
			} else if (c.getPathFindingNexus() < closestOfNexus
					.getPathFindingNexus() && c.getPathFindingNexus() != -1)
				closestOfNexus = c;
		}
		if (closestOfNexus.canPass(character)) {
			System.out.println("aimNexus move1 !");
			moveStrategy.action(character);
		} else {
			if (character.minimalDistance(closestOfNexus.getDefence()) > character
					.getRange()) {
				System.out.println("aimNexus move2 !" + character.minimalDistance(closestOfNexus.getDefence()) + "   " + character
						.getRange());
				moveStrategy.action(character);
			} else {
				System.out.println("distance : "
						+ character.distance(closestOfNexus.getDefence()));
				System.out.println("aimNexus attack !");
				List<Entity> attackableEntities = new ArrayList<Entity>();
				attackableEntities.add(closestOfNexus.getDefence());
				attackStrategy.action(character, attackableEntities);
			}
		}

	}

}
