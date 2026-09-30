export interface Facility {
  id: number;
  name: string;
  description: string;
  capacity: number;
  hourlyRate: number;
  isActive: boolean;
  requiresApproval: boolean;
}

export interface CreateFacilityDTO {
  name: string;
  description: string;
  capacity: number;
  hourlyRate: number;
  isActive: boolean;
  requiresApproval: boolean;
}