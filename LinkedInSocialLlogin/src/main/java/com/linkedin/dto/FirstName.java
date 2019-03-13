package com.linkedin.dto;

public class FirstName {
	Localized LocalizedObject;
	PreferredLocale PreferredLocaleObject;

	// Getter Methods

	public Localized getLocalized() {
		return LocalizedObject;
	}

	public PreferredLocale getPreferredLocale() {
		return PreferredLocaleObject;
	}

	// Setter Methods

	public void setLocalized(Localized localizedObject) {
		this.LocalizedObject = localizedObject;
	}

	public void setPreferredLocale(PreferredLocale preferredLocaleObject) {
		this.PreferredLocaleObject = preferredLocaleObject;
	}
}
