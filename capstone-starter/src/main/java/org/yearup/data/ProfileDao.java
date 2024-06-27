package org.yearup.data;

import org.yearup.models.Profile;

public interface ProfileDao
{
    Profile create(Profile profile);

    // optional phase 4 starts
    Profile getByUserId(int userId);
    void update(Profile profile);
    // optional phase 4 ends
}
