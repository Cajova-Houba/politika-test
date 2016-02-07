package org.politika.membernet;

import java.util.List;

import com.yoso.dev.membernet.membership.domain.Membership;

public interface MembernetManager {
	
	/**
	 * Check if the member with requesterId can access (view and change) the data of member with targetId.
	 * Typically one member access other member's data if:
	 *   1. Requester is the target (ids are same)
	 *   2. Requester is an admin of society the target is member of.
	 * @param requesterId Membership Id of requester member.
	 * @param targetId Membership Id of target member.
	 * @return True if requester can access, false if he can't.
	 */
	public boolean canAccess(long requesterId, long targetId);
	
	/**
	 * Lists all memberships available.
	 * @return List of memberships.
	 */
	public List<Membership> listAll();
	
	/**
	 * List all membership in the society.
	 * @param societyId Id of the society.
	 * @return List of memberships.
	 */
	public List<Membership> listAll(long societyId);
}
