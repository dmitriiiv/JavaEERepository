package by.agency.travel.web.validator;

import javax.validation.GroupSequence;
import javax.validation.groups.Default;

import by.agency.travel.entity.User;

@GroupSequence({Default.class, User.RegExp.class})
public interface UserChecks {
}
